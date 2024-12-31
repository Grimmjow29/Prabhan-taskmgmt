package com.prabhan.TaskMgmSystem.controller;

import com.prabhan.TaskMgmSystem.model.Task;
import com.prabhan.TaskMgmSystem.service.TaskServiceImpl;

import jakarta.annotation.Priority;
import jakarta.transaction.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskServiceImpl taskService;

    @PostMapping("/")
    public String createTask(Task task){
        taskService.saveTask(task);
        return "Task added.";
    }

    @GetMapping("/{id}")
    public Optional<Task> getTaskById(@RequestParam Long id){
        return taskService.getTaskById(id);
    }

    @GetMapping("/")
    public List<Task> getTasks(){
        return taskService.getAllTasks();
    }

    @DeleteMapping("/{id}")
    public void deleteTaskById(@RequestParam Long id){
        taskService.deleteTask(id);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Task>> getTasksByStatus(@PathVariable String status) {
        List<Task> tasks = taskService.getTasksByStatus(status);
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/priority/{priority}")
        public ResponseEntity<List<Task>> getTasksByPriority(@PathVariable String priority){
            List<Task> tasks = taskService.getTasksByPriority(priority);
            return ResponseEntity.ok(tasks);
        }
        @GetMapping("/duedate/{duedate}")
        public ResponseEntity<List<Task>> getTasksByDueDateBefore(@PathVariable String date) {
            LocalDate dueDate = LocalDate.parse(date);
            List<Task> tasks = taskService.getTasksByDueDateBefore(dueDate);
            return ResponseEntity.ok(tasks);
        }


}
