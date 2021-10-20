package de.fhswf.todoappservice;

import de.fhswf.todoappservice.dto.PriorityDto;
import de.fhswf.todoappservice.dto.ProjectDto;
import de.fhswf.todoappservice.dto.StatusDto;
import de.fhswf.todoappservice.dto.TaskDto;
import de.fhswf.todoappservice.model.Priority;
import de.fhswf.todoappservice.model.Project;
import de.fhswf.todoappservice.model.Status;
import de.fhswf.todoappservice.model.Task;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ToDoAppServiceApplication {

@Bean
public ModelMapper modelMapper() {
    ModelMapper mapper = new ModelMapper();

    // Entity -> Dto
    mapper.createTypeMap(Priority.class, PriorityDto.class);
    mapper.createTypeMap(Project.class, ProjectDto.class);
    mapper.createTypeMap(Status.class, StatusDto.class);
    mapper.createTypeMap(Task.class, TaskDto.class);

    // Dto -> Entity
    mapper.createTypeMap(PriorityDto.class, Priority.class);
    mapper.createTypeMap(ProjectDto.class, Project.class);
    mapper.createTypeMap(StatusDto.class, Status.class);

    return mapper;

}

    public static void main(String[] args) {
        SpringApplication.run(ToDoAppServiceApplication.class, args);
    }

}
