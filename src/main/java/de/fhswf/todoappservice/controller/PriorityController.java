package de.fhswf.todoappservice.controller;

import de.fhswf.todoappservice.model.Priority;
import de.fhswf.todoappservice.model.Status;
import de.fhswf.todoappservice.repository.PriorityRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class PriorityController {

    private PriorityRepository priorityRepository;

    PriorityController(PriorityRepository priorityRepository) { this.priorityRepository = priorityRepository; }

    @GetMapping("/priority")
    public List<Priority> getAllPriorities() {
        return this.priorityRepository.findAll();
    }

}
