package com.prabhan.TaskMgmSystem.service;

import com.prabhan.TaskMgmSystem.model.User;
import com.prabhan.TaskMgmSystem.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepo userRepo;

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepo.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return List.of((User) userRepo.findAll());
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }
}
