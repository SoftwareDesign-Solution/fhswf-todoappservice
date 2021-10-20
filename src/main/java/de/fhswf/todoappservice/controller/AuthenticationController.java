package de.fhswf.todoappservice.controller;

import de.fhswf.todoappservice.exception.EntityNotFoundException;
import de.fhswf.todoappservice.request.AuthenticationRequest;
import de.fhswf.todoappservice.response.JWTTokenResponse;
import de.fhswf.todoappservice.service.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping
public class AuthenticationController {

    private AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        System.out.println("AuthenticationController");
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<JWTTokenResponse> createCustomer(@RequestBody AuthenticationRequest request) {

        System.out.println("login");
        System.out.println(request.getUsername());
        System.out.println(request.getPassword());
        return new ResponseEntity<JWTTokenResponse>(authenticationService.generateJWTToken(request.getUsername(), request.getPassword()), HttpStatus.OK);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handleEntityNotFoundException(EntityNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

}
