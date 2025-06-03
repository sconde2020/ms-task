package com.sconde.task.service;

import com.sconde.task.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    List<Task> getAll();

    Task save(Task task);

    Optional<Task> getById(Long id);

    void delete(Long id);
}

