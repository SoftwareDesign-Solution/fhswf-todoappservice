package de.fhswf.todoappservice.controller;

import de.fhswf.todoappservice.dto.ProjectDto;
import de.fhswf.todoappservice.model.Project;
import de.fhswf.todoappservice.model.Task;
import de.fhswf.todoappservice.repository.ProjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ProjectController {

    private ProjectRepository projectRepository;

    ProjectController(ProjectRepository projectRepository) { this.projectRepository = projectRepository;}

    @GetMapping("/projects")
    public List<Project> getAllProjects() {
        return this.projectRepository.findAll();
    }

    @GetMapping("/projects/{id}")
    public ProjectDto getProjectById(@PathVariable("id") int id) {

        Optional<Project> project = this.projectRepository.findById(id);

        ModelMapper mapper = new ModelMapper();

        ProjectDto projectDto = mapper.map(project.get(), ProjectDto.class);

        return projectDto;

    }

    @GetMapping("/projects/{id}/tasks")
    public List<Task> getTasksByProjectId(@PathVariable("id") int id) {

        Project project = this.projectRepository.getById(id);
        return project.getTasks();

    }

    @PostMapping("/projects")
    public void createProject(@RequestBody Project project) {
        this.projectRepository.save(project);
    }

    @PutMapping("/projects/{id}")
    public void updateProject(@PathVariable("id") int id, @RequestBody Project project) {
        this.projectRepository.save(project);
    }

    @DeleteMapping("/projects/{id}")
    public void deleteProject(@PathVariable("id") int id) {

        Project project = this.projectRepository.getById(id);
        this.projectRepository.delete(project);

    }

    @DeleteMapping("/projects")
    public void deleteAllProjects() {
        this.projectRepository.deleteAll();
    }

}
