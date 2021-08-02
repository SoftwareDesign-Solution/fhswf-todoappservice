package de.fhswf.todoappservice.controller;

import de.fhswf.todoappservice.model.Task;
import de.fhswf.todoappservice.repository.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TaskController {

    private TaskRepository taskRepository;

    TaskController(TaskRepository taskRepository) { this.taskRepository = taskRepository; }

    @GetMapping("/tasks")
    public List<Task> getAllTasks() { return this.taskRepository.findAll(); }

    @GetMapping("/tasks/{id}")
    public Optional<Task> getTaskById(@PathVariable("id") int id) { return this.taskRepository.findById(id); }

    @PostMapping("/tasks")
    public void createTask(@RequestBody Task task) { this.taskRepository.save(task); }

    @PutMapping("/tasks/{id}")
    public void updateProject(@PathVariable("id") int id, @RequestBody Task task) { this.taskRepository.save(task); }

    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable("id") int id) {

        Task task = this.taskRepository.getById(id);
        this.taskRepository.delete(task);

    }

    @DeleteMapping("/tasks")
    public void deleteAllTasks() { this.taskRepository.deleteAll(); }

}
