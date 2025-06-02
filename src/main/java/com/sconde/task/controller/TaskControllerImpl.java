package com.sconde.task.controller;

import com.sconde.task.exception.ResourceNotFoundException;
import com.sconde.task.model.Task;
import com.sconde.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskControllerImpl implements TaskController {

    @Autowired
    private TaskService taskService;

    @Override
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAll());
    }

    @Override
    public ResponseEntity<Task> createTasks(Task task) {
        return ResponseEntity.status(201).body(taskService.save(task));
    }

    @Override
    public ResponseEntity<Task> getTaskById(Long id) {
        return taskService.getById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Task with ID " + id + " not found"));
    }

    @Override
    public ResponseEntity<Task> updateTask(Long id, Task taskDetails) {
        return taskService.getById(id).map(task -> {
            task.setTitle(taskDetails.getTitle());
            task.setDescription(taskDetails.getDescription());
            task.setDone(taskDetails.getDone());
            task.setCreatedAt(taskDetails.getCreatedAt());
            task.setUpdatedAt(taskDetails.getUpdatedAt());
            return ResponseEntity.ok(taskService.save(task));
        }).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<?> deleteTask(Long id) {
        if (taskService.getById(id).isPresent()) {
            taskService.delete(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
