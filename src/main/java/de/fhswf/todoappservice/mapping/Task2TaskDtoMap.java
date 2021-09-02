package de.fhswf.todoappservice.mapping;

import de.fhswf.todoappservice.dto.TaskDto;
import de.fhswf.todoappservice.model.Task;
import org.modelmapper.PropertyMap;

public class Task2TaskDtoMap extends PropertyMap<Task, TaskDto> {

    @Override
    protected void configure() {
        //map().setProjectId(source.getProject().getId());
        //map().getProject().setId(source.getProject().getId());
        //map().getProject().setName(source.getProject().getName());
        //map().getProject().setCreated(source.getProject().getCreated());
        //map().getProject().setUpdated(source.getProject().getUpdated());

        //map().getStatus().setId(source.getStatus().getId());
        //map().getStatus().setName(source.getStatus().getName());

        //map().getPriority().setId(source.getPriority().getId());
        //map().getPriority().setName(source.getPriority().getName());

    }

}
