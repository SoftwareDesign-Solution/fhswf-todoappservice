package de.fhswf.todoappservice.controller;

import de.fhswf.todoappservice.dto.TaskDto;
import de.fhswf.todoappservice.model.Task;
import de.fhswf.todoappservice.repository.TaskRepository;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class DebugController {

    private TaskRepository taskRepository;
    private ModelMapper mapper;

    DebugController(TaskRepository taskRepository, ModelMapper mapper) {
        this.taskRepository = taskRepository;
        this.mapper = mapper;
    }

    @GetMapping("/debug")
    public String GetMessage() {
        return "Hello World!";
    }

    @PostMapping("/testmapping")
    public Task testMapping(@RequestBody TaskDto taskDto) {

        //ModelMapper modelMapper = new ModelMapper();
        //modelMapper.addMappings(new TaskMap2(this.priorityRepository, this.projectRepository, this.statusRepository));

        Task task = this.mapper.map(taskDto, Task.class);

        this.taskRepository.save(task);

        return task;

    }

    /*
    private TaskRepository taskRepository;
    private StatusRepository statusRepository;
    private PriorityRepository priorityRepository;
    private ProjectRepository projectRepository;

    DebugController(TaskRepository taskRepository, StatusRepository statusRepository, PriorityRepository priorityRepository, ProjectRepository projectRepository) {
        this.taskRepository = taskRepository;
        this.statusRepository = statusRepository;
        this.priorityRepository = priorityRepository;
        this.projectRepository = projectRepository;
    }
    */

}
