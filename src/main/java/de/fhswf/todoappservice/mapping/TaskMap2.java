package de.fhswf.todoappservice.mapping;

import de.fhswf.todoappservice.dto.TaskDto;
import de.fhswf.todoappservice.model.Priority;
import de.fhswf.todoappservice.model.Project;
import de.fhswf.todoappservice.model.Status;
import de.fhswf.todoappservice.model.Task;
import de.fhswf.todoappservice.repository.PriorityRepository;
import de.fhswf.todoappservice.repository.ProjectRepository;
import de.fhswf.todoappservice.repository.StatusRepository;
import org.modelmapper.PropertyMap;

public class TaskMap2 extends PropertyMap<TaskDto, Task> {

    private PriorityRepository priorityRepository;
    private ProjectRepository projectRepository;
    private StatusRepository statusRepository;

    public TaskMap2(PriorityRepository priorityRepository, ProjectRepository projectRepository, StatusRepository statusRepository) {
        this.priorityRepository = priorityRepository;
        this.projectRepository = projectRepository;
        this.statusRepository = statusRepository;
    }

    @Override
    protected void configure() {
        //Project project = this.projectRepository.findById(source.getProjectId()).get();
        //map().setProject(project);

        //Status status = this.statusRepository.findById(source.getStatusId()).get();
        //map().setStatus(status);

        //Priority priority = this.priorityRepository.findById(source.getPriorityId()).get();
        //map().setPriority(priority);

    }

}
