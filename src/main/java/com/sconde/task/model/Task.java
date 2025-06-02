package com.sconde.task.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Description is required")
    @Column(columnDefinition = "TEXT")
    private String description;

    private Boolean done = false;

    private LocalDate createdAt = LocalDate.now();

    private LocalDate updatedAt = LocalDate.now();;
}

