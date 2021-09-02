package de.fhswf.todoappservice.controller;

import de.fhswf.todoappservice.dto.TaskDto;
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
    private ModelMapper mapper;

    TaskController(TaskRepository taskRepository, ModelMapper modelMapper) {
        this.taskRepository = taskRepository;
        this.mapper = modelMapper;
    }

    @GetMapping("/tasks")
    public List<TaskDto> getAllTasks() {

        List<Task> tasks = this.taskRepository.findAll();

        Type listType = new TypeToken<List<TaskDto>>() {}.getType();
        List<TaskDto> taskDtos = mapper.map(tasks, listType);

        return taskDtos;

    }

    @GetMapping("/tasks/{id}")
    public TaskDto getTaskById(@PathVariable("id") int id) {

        Optional<Task> task = this.taskRepository.findById(id);

        TaskDto taskDto = mapper.map(task.get(), TaskDto.class);

        return taskDto;

    }

    @PostMapping("/tasks")
    public void createTask(@RequestBody TaskDto taskDto) {

        Task task = null;


        task = mapper.map(taskDto, Task.class);

        this.taskRepository.save(task);

    }

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
