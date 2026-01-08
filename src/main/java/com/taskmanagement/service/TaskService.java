package com.taskmanagement.service;

import com.taskmanagement.dto.TaskDto;
import com.taskmanagement.enums.TaskStatus;
import com.taskmanagement.exception.NotFoundException;
import com.taskmanagement.model.Task;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private final Map<Long, Task> tasks = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public Task createTask(TaskDto taskDto) {
        long id = idGenerator.getAndIncrement();
        Task task = new Task();
        task.setId(id);
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setStatus(TaskStatus.PENDING);
        task.setUserId(taskDto.getUserId());
        tasks.put(id, task);
        return task;
    }

    public List<Task> getTasksByUser(Long userId) {
        return tasks.values()
                .stream()
                .filter(t -> t.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

    public Task updateStatus(Long taskId, TaskStatus status) {
        Task task = tasks.get(taskId);
        if (task == null) {
            throw new NotFoundException("Task not found");
        }
        task.setStatus(status);
        return task;
    }
}