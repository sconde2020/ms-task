package com.sconde.task.application.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TaskDto {
        private Long id;
        @NotBlank(message = "Title is required")
        private String title;
        @NotBlank(message = "Description is required")
        private String description;
        @NotBlank(message = "Priority is required")
        private String priority;
        private boolean done;
        private LocalDate dueDate;
        private LocalDate createdAt;
        private LocalDate updatedAt;
}

