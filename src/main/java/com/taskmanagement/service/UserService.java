package com.taskmanagement.service;

import com.taskmanagement.dto.UserDto;
import com.taskmanagement.exception.EmailAlreadyExistsException;
import com.taskmanagement.exception.NotFoundException;
import com.taskmanagement.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserService {

    private final Map<Long, User> users = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public User createUser(UserDto newUserDto) {
        long id = idGenerator.getAndIncrement();
        if(users.values().stream().anyMatch(user -> user.getEmail().equals(newUserDto.getEmail()))){
            throw new EmailAlreadyExistsException("Email already exists");
        }
        User user = new User();
        user.setId(id);
        user.setEmail(newUserDto.getEmail());
        user.setName(newUserDto.getName());
        users.put(id, user);
        return user;
    }
    public User getUser(Long id) {
        User user = users.get(id);
        if (user == null) {
            throw new NotFoundException("User not found");
        }
        return user;
    }

    public boolean exists(Long id) {
        return users.containsKey(id);
    }
}