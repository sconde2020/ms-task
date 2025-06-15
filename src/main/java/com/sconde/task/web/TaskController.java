package com.sconde.task.web;

import com.sconde.task.application.dto.TaskDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
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
    ResponseEntity<List<TaskDto>> getAllTasks();


    @Operation(summary = "Create a new task",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            schema = @Schema(implementation = TaskDto.class),
                            examples = @ExampleObject(
                                    name = "New Task Example",
                                    value = """
                                            {
                                              "title": "Buy groceries",
                                              "description": "Milk, eggs, bread, fruits",
                                              "priority": "High",
                                              "done": false,
                                              "dueDate": "2025-06-20",
                                              "createdAt": "2025-06-15",
                                              "updatedAt": "2025-06-15"
                                            }
                                            """
                            )
                    )
            ))
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Task created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    ResponseEntity<TaskDto> createTasks(@Valid @RequestBody TaskDto dto);


    @Operation(summary = "Get task by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Task found"),
            @ApiResponse(responseCode = "404", description = "Task not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/{id}")
    ResponseEntity<TaskDto> getTaskById(
            @Parameter(description = "ID of the task to retrieve", example = "1")
            @PathVariable Long id);


    @Operation(summary = "Update a given task",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            schema = @Schema(implementation = TaskDto.class),
                            examples = @ExampleObject(
                                    name = "Update Task Example",
                                    value = """
                                            {
                                              "title": "Update groceries list",
                                              "description": "Add yogurt and remove bread",
                                              "priority": "Medium",
                                              "done": false,
                                              "dueDate": "2025-06-22",
                                              "createdAt": "2025-06-15",
                                              "updatedAt": "2025-06-16"
                                            }
                                            """
                            )
                    )
            ))
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Task updated successfully"),
            @ApiResponse(responseCode = "404", description = "Task not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PutMapping("/{id}")
    ResponseEntity<TaskDto> updateTask(
            @Parameter(description = "ID of the task to update", example = "1")
            @PathVariable Long id,
            @RequestBody TaskDto dto);


    @Operation(summary = "Delete a given task")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Task deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Task not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteTask(
            @Parameter(description = "ID of the task to delete", example = "1")
            @PathVariable Long id);
}

