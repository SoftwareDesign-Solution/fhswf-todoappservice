package de.fhswf.todoappservice.controller;

import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class DebugController {

    @GetMapping("/debug")
    public String GetMessage() {
        return "Hello World!";
    }
}
