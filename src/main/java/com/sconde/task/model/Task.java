package com.sconde.task.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")

    private String description;

    private Boolean done = false;

    private LocalDate createdAt;

    private LocalDate updatedAt;
}

