package de.fhswf.todoappservice.mapping;

import de.fhswf.todoappservice.dto.TaskDto;
import de.fhswf.todoappservice.model.Project;
import de.fhswf.todoappservice.model.Task;
import de.fhswf.todoappservice.repository.ProjectRepository;
import org.modelmapper.PropertyMap;

public class TaskMap extends PropertyMap<TaskDto, Task> {

    private ProjectRepository projectRepository;

    TaskMap(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    protected void configure() {
        Project project = this.projectRepository.getById(source.getProjectId());
        map().setProject(project);
    }

}
