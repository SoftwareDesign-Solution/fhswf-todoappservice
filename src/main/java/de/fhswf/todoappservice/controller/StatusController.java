package de.fhswf.todoappservice.controller;

import de.fhswf.todoappservice.dto.StatusDto;
import de.fhswf.todoappservice.model.Status;
import de.fhswf.todoappservice.repository.StatusRepository;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class StatusController {

    private StatusRepository statusRepository;
    private ModelMapper mapper;

    StatusController(StatusRepository statusRepository, ModelMapper mapper) {
        this.statusRepository = statusRepository;
        this.mapper = mapper;
    }

    @GetMapping("/status")
    public List<Status> getAllStatus() {
        return this.statusRepository.findAll();
    }

    @GetMapping("/status/{id}")
    public StatusDto getStatusById(@PathVariable("id") int id) {

        Optional<Status> status = this.statusRepository.findById(id);

        StatusDto statusDto = mapper.map(status.get(), StatusDto.class);

        return statusDto;

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
