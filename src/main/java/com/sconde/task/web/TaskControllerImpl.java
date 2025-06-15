package com.sconde.task.web;

import com.sconde.task.application.dto.TaskDto;
import com.sconde.task.application.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskControllerImpl implements TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskControllerImpl(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public ResponseEntity<List<TaskDto>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAll());
    }

    @Override
    public ResponseEntity<TaskDto> createTasks(@RequestBody TaskDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.save(dto));
    }

    @Override
    public ResponseEntity<TaskDto> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getByIdOrThrow(id));
    }

    @Override
    public ResponseEntity<TaskDto> updateTask(@PathVariable Long id, @RequestBody TaskDto dto) {
        return ResponseEntity.ok(taskService.update(id, dto));
    }

    @Override
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        taskService.delete(id);
        return ResponseEntity.ok().build();
    }
}

