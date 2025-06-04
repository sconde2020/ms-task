package com.sconde.task.application.service;

import com.sconde.task.application.dto.TaskDto;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    List<TaskDto> getAll();

    TaskDto save(TaskDto taskDto);

    Optional<TaskDto> getById(Long id);

    void delete(Long id);
}

