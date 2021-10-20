package de.fhswf.todoappservice.model;

import lombok.Data;
import javax.persistence.*;

import javax.persistence.*;

@Data
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String password;

    private String firstname;
    private String lastname;

}
