package de.fhswf.todoappservice.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

}
