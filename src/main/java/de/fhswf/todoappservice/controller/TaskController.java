package de.fhswf.todoappservice.controller;

import de.fhswf.todoappservice.dto.TaskDto;
import de.fhswf.todoappservice.mapping.TaskDtoMap;
import de.fhswf.todoappservice.model.Task;
import de.fhswf.todoappservice.repository.TaskRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeToken;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TaskController {

    private TaskRepository taskRepository;

    TaskController(TaskRepository taskRepository) { this.taskRepository = taskRepository; }

    @GetMapping("/tasks")
    public List<TaskDto> getAllTasks() {

        List<Task> tasks = this.taskRepository.findAll();

        /*
        PropertyMap<Task, TaskDto> taskMap = new PropertyMap<>() {
            @Override
            protected void configure() {
                map().setStatus(source.getStatus().getId());
                map().setProject(source.getProject().getName());
                map().setProjectId(source.getProject().getId());
            }
        };
        */

        ModelMapper mapper = new ModelMapper();
        mapper.addMappings(new TaskDtoMap());

        Type listType = new TypeToken<List<TaskDto>>() {}.getType();
        List<TaskDto> taskDtos = mapper.map(tasks, listType);

        return taskDtos;

    }

    @GetMapping("/tasks/{id}")
    public TaskDto getTaskById(@PathVariable("id") int id) {

        Optional<Task> task = this.taskRepository.findById(id);

        PropertyMap<Task, TaskDto> taskMap = new PropertyMap<>() {
            @Override
            protected void configure() {
                map().setStatus(source.getStatus().getId());
                map().setProject(source.getProject().getName());
                map().setProjectId(source.getProject().getId());
            }
        };

        ModelMapper mapper = new ModelMapper();
        mapper.addMappings(taskMap);

        TaskDto taskDto = mapper.map(task.get(), TaskDto.class);

        return taskDto;

    }

    @PostMapping("/tasks")
    public void createTask(@RequestBody Task task) { this.taskRepository.save(task); }

    @PutMapping("/tasks/{id}")
    public void updateTask(@PathVariable("id") int id, @RequestBody Task task) { this.taskRepository.save(task); }

    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable("id") int id) {

        Task task = this.taskRepository.getById(id);
        this.taskRepository.delete(task);

    }

    @DeleteMapping("/tasks")
    public void deleteAllTasks() { this.taskRepository.deleteAll(); }

}
