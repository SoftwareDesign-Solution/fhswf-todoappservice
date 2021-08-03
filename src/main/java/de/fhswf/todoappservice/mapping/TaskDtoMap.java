package de.fhswf.todoappservice.mapping;

import de.fhswf.todoappservice.dto.TaskDto;
import de.fhswf.todoappservice.model.Task;
import org.modelmapper.PropertyMap;

public class TaskDtoMap extends PropertyMap<Task, TaskDto> {

    @Override
    protected void configure() {
        map().setStatus(source.getStatus().getId());
        map().setProject(source.getProject().getName());
        map().setProjectId(source.getProject().getId());
    }

}
