package com.sconde.task.web;

import com.sconde.shared.exception.ResourceNotFoundException;
import com.sconde.task.application.dto.TaskDto;
import com.sconde.task.application.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class TaskControllerImpl implements TaskController {

    @Autowired
    private TaskService taskService;

    @Override
    public ResponseEntity<List<TaskDto>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAll());
    }

    @Override
    public ResponseEntity<TaskDto> createTasks(TaskDto dto) {
        return ResponseEntity.status(201).body(taskService.save(dto));
    }

    @Override
    public ResponseEntity<TaskDto> getTaskById(Long id) {
        return taskService.getById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Task with ID " + id + " not found"));
    }

    @Override
    public ResponseEntity<TaskDto> updateTask(Long id, TaskDto dto) {
        return taskService.getById(id)
                .map(existing -> {
                    dto.setId(id);
                    dto.setUpdatedAt(LocalDate.now());
                    return ResponseEntity.ok(taskService.save(dto));
                })
                .orElseThrow(() -> new ResourceNotFoundException("Task with ID " + id + " not found"));
    }

    @Override
    public ResponseEntity<?> deleteTask(Long id) {
        return taskService.getById(id)
                .map(found -> {
                    taskService.delete(id);
                    return ResponseEntity.ok().build();
                })
                .orElseThrow(() -> new ResourceNotFoundException("Task with ID " + id + " not found"));
    }
}
