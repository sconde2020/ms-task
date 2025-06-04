package com.sconde.task.application.mapper;

import com.sconde.task.application.dto.TaskDto;
import com.sconde.task.domain.model.Task;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskDto toDto(Task task);

    Task toEntity(TaskDto dto);

    List<TaskDto> toDtoList(List<Task> taskList);

}

