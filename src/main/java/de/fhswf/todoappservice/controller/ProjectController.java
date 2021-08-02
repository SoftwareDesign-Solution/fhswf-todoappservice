package de.fhswf.todoappservice.controller;

import de.fhswf.todoappservice.model.Project;
import de.fhswf.todoappservice.repository.ProjectRepository;
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
    public Optional<Project> getProjectById(@PathVariable("id") int id) {
        return this.projectRepository.findById(id);
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
