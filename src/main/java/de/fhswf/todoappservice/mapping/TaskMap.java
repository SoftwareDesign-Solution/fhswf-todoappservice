package de.fhswf.todoappservice.mapping;

import de.fhswf.todoappservice.dto.TaskDto;
import de.fhswf.todoappservice.model.Priority;
import de.fhswf.todoappservice.model.Project;
import de.fhswf.todoappservice.model.Status;
import de.fhswf.todoappservice.model.Task;
import org.modelmapper.PropertyMap;

public class TaskMap extends PropertyMap<TaskDto, Task> {

    @Override
    protected void configure() {

        //map().setPriority(new Priority(source.getPriorityId()));
        //map().setStatus(new Status(source.getStatusId()));
        //map().setProject(new Project(source.getProjectId()));

        //skip(source.getPriority());
        //skip(source.getProject());
        //skip(source.getStatus());

    }

}
