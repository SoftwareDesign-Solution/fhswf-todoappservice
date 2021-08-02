package de.fhswf.todoappservice.controller;

import de.fhswf.todoappservice.model.Project;
import de.fhswf.todoappservice.model.Status;
import de.fhswf.todoappservice.model.Task;
import de.fhswf.todoappservice.repository.StatusRepository;
import de.fhswf.todoappservice.repository.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class StatusController {

    private StatusRepository statusRepository;

    StatusController(StatusRepository statusRepository) { this.statusRepository = statusRepository; }

    @GetMapping("/status")
    public List<Status> getAllStatus() {
        return this.statusRepository.findAll();
    }

    @GetMapping("/status/{id}")
    public Optional<Status> getStatusById(@PathVariable("id") int id) {
        return this.statusRepository.findById(id);
    }

    @PostMapping("/status")
    public void createStatus(@RequestBody Status status) {
        this.statusRepository.save(status);
    }

    @PutMapping("/status/{id}")
    public void updateStatus(@PathVariable("id") int id, @RequestBody Status status) {
        this.statusRepository.save(status);
    }

    @DeleteMapping("/status/{id}")
    public void deleteStatus(@PathVariable("id") int id) {

        Status status = this.statusRepository.getById(id);
        this.statusRepository.delete(status);

    }

    @DeleteMapping("/status")
    public void deleteAllStatus() {
        this.statusRepository.deleteAll();
    }

}
