package de.fhswf.todoappservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ToDoAppServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToDoAppServiceApplication.class, args);
    }

}
