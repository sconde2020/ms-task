package com.sconde.task.controller;

import com.sconde.task.model.Task;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Task API", description = "Operations related to tasks")
@RequestMapping("/api/tasks")
public interface TaskController {

    @Operation(summary = "Get all tasks")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Tasks retrieved successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    ResponseEntity<List<Task>> getAllTasks();

    @Operation(summary = "Create a new task")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Task created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    ResponseEntity<Task> createTasks(@Valid @RequestBody Task task);

    @Operation(summary = "Get task by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Task found"),
            @ApiResponse(responseCode = "404", description = "Task not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/{id}")
    ResponseEntity<Task> getTaskById(@PathVariable Long id);

    @Operation(summary = "Update a given task")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Task updated successfully"),
            @ApiResponse(responseCode = "404", description = "Task not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PutMapping("/{id}")
    ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task taskDetails);

    @Operation(summary = "Delete a given task")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Task deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Task not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteTask(@PathVariable Long id);
}
