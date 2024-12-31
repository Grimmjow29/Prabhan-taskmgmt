package com.prabhan.TaskMgmSystem.service;

import com.prabhan.TaskMgmSystem.model.Task;
import com.prabhan.TaskMgmSystem.repo.TaskRepo;
import jakarta.transaction.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    TaskRepo taskRepo;

    @Override
    public Task saveTask(Task task) {
       return taskRepo.save(task);

    }

    @Override
    public Optional<Task> getTaskById(Long id) {
        return taskRepo.findById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    @Override
    public void deleteTask(Long id) {
        taskRepo.deleteById(id);
    }

    @Override
    public List<Task> getTasksByStatus(String status) {
        return taskRepo.findByStatus(status);
    }

    @Override
    public List<Task> getTasksByPriority(String priority) {
        return taskRepo.findByPriority(priority);
    }

    @Override
    public List<Task> getTasksByDueDateBefore(LocalDate dueDate) {
        return taskRepo.findByDueDateBefore(dueDate);
    }
}
