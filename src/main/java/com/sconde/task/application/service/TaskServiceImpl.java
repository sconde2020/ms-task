package com.sconde.task.application.service;

import com.sconde.task.application.dto.TaskDto;
import com.sconde.task.application.mapper.TaskMapper;
import com.sconde.task.domain.model.Task;
import com.sconde.task.infrastructure.TaskRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepositoryImpl taskRepository;

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public List<TaskDto> getAll() {
        taskRepository.findAll().forEach(System.out::println);
        return taskMapper.toDtoList(taskRepository.findAll());
    }

    @Override
    public TaskDto save(TaskDto taskDto) {
        Task task = taskMapper.toEntity(taskDto);
        Task saved = taskRepository.save(task);
        return taskMapper.toDto(saved);
    }

    @Override
    public Optional<TaskDto> getById(Long id) {
        return taskRepository.findById(id).map(taskMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
}
