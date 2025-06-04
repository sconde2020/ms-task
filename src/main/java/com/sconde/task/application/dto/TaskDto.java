package com.sconde.task.application.dto;

import java.time.LocalDate;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TaskDto {
        private Long id;
        private String title;
        private String description;
        private String priority;
        private boolean done;
        private LocalDate dueDate;
        private LocalDate createdAt;
        private LocalDate updatedAt;
}

