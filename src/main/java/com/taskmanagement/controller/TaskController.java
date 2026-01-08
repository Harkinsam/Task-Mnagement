package com.taskmanagement.controller;

import com.taskmanagement.dto.TaskDto;
import com.taskmanagement.enums.TaskStatus;
import com.taskmanagement.model.Task;
import com.taskmanagement.service.TaskService;
import com.taskmanagement.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    private final TaskService taskService;
    private final UserService userService;

    public TaskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @PostMapping("/tasks")
    public ResponseEntity<Task> createTask(@Valid @RequestBody TaskDto taskDto) {
        if (!userService.exists(taskDto.getUserId())){
            throw new RuntimeException("User does not exist");
        }
        Task createdTask = taskService.createTask(taskDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }

    @GetMapping("/users/{id}/tasks")
    public List<Task> getUserTasks(@PathVariable Long id) {
        userService.getUser(id);
        return taskService.getTasksByUser(id);
    }

    @PutMapping("/tasks/{id}/status")
    public ResponseEntity<Task> updateStatus(@PathVariable Long id, @Valid @RequestParam TaskStatus status) {
        Task task = taskService.updateStatus(id, status);
        return ResponseEntity.ok(task);
    }
}