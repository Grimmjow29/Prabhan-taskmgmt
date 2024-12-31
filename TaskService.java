package com.prabhan.TaskMgmSystem.service;

import com.prabhan.TaskMgmSystem.model.Task;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public interface TaskService {
    Task saveTask(Task task);
    Optional<Task> getTaskById(Long id);
    List<Task> getAllTasks();
    void deleteTask(Long id);
    List<Task> getTasksByStatus(String status);
    List<Task> getTasksByPriority(String priority);
    List<Task> getTasksByDueDateBefore(LocalDate dueDate);
}
