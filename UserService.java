package com.prabhan.TaskMgmSystem.service;

import com.prabhan.TaskMgmSystem.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    User saveUser(User user);
    Optional<User> getUserById(Long id);
    List<User> getAllUsers();
    void deleteUser(Long id);
}
