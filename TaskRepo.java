package com.prabhan.TaskMgmSystem.repo;

import com.prabhan.TaskMgmSystem.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long> {


    List<Task> findByStatus(String status);

    List<Task> findByPriority(String priority);

    List<Task> findByDueDateBefore(LocalDate dueDate);

}
