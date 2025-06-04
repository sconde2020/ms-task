package com.sconde.task.infrastructure;

import com.sconde.task.domain.model.Task;
import com.sconde.task.domain.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TaskRepositoryImpl implements TaskRepository {

    private final SpringDataTaskRepository jpaRepository;

    @Autowired
    public TaskRepositoryImpl(SpringDataTaskRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<Task> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public Optional<Task> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public Task save(Task task) {
        return jpaRepository.save(task);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}
