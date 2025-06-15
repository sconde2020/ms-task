package com.sconde.task.application.service;

import com.sconde.task.application.dto.TaskDto;

import java.util.List;

public interface TaskService {
    List<TaskDto> getAll();

    TaskDto save(TaskDto dto);

    TaskDto getByIdOrThrow(Long id);

    TaskDto update(Long id, TaskDto dto);

    void delete(Long id);
}

