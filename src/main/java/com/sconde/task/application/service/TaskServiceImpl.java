package com.sconde.task.application.service;

import com.sconde.shared.exception.ResourceNotFoundException;
import com.sconde.task.application.dto.TaskDto;
import com.sconde.task.application.mapper.TaskMapper;
import com.sconde.task.domain.model.Task;
import com.sconde.task.infrastructure.TaskRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepositoryImpl taskRepository;

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public List<TaskDto> getAll() {
        return taskMapper.toDtoList(taskRepository.findAll());
    }

    @Override
    public TaskDto save(TaskDto taskDto) {
        Task task = taskMapper.toEntity(taskDto);
        Task saved = taskRepository.save(task);
        return taskMapper.toDto(saved);
    }

    @Override
    public TaskDto getByIdOrThrow(Long id) {
        return taskRepository.findById(id)
                .map(taskMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Task with ID " + id + " not found"));
    }

    @Override
    public TaskDto update(Long id, TaskDto dto) {
        taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task with ID " + id + " not found"));

        dto.setId(id);
        dto.setUpdatedAt(LocalDate.now());

        Task updated = taskRepository.save(taskMapper.toEntity(dto));
        return taskMapper.toDto(updated);
    }

    @Override
    public void delete(Long id) {
        taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task with ID " + id + " not found"));
        taskRepository.deleteById(id);
    }
}
