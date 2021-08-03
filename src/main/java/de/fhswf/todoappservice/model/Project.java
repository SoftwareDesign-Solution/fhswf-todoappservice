package de.fhswf.todoappservice.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @CreatedDate
    private Date created;

    @LastModifiedDate
    private Date updated;

    @OneToMany
    private List<Task> tasks;

}
