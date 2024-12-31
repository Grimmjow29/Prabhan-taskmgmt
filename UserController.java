package com.prabhan.TaskMgmSystem.controller;

import com.prabhan.TaskMgmSystem.model.User;
import com.prabhan.TaskMgmSystem.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/")
    public String createUser(User user){
        userService.saveUser(user);
        return "New User Added.";
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@RequestParam Long id){
        return userService.getUserById(id);
    }

    @GetMapping("/")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@RequestParam Long id){
        userService.deleteUser(id);
    }

}
