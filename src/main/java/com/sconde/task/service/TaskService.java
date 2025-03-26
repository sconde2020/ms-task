package com.sconde.task.service;

import com.sconde.task.model.Task;
import com.sconde.task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public Task save(Task task) {
        return taskRepository.save(task);
    }

    public Optional<Task> getById(Long id) {
        return taskRepository.findById(id);
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
}

