package com.sconde.task.infrastructure;

import com.sconde.task.domain.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataTaskRepository extends JpaRepository<Task, Long> {

}
