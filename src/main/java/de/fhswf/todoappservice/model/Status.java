package de.fhswf.todoappservice.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany
    @JoinColumn(name = "status")
    private List<Task> tasks;

    public Status() {}

    public Status(Integer id) {
        this.id = id;
    }

}
