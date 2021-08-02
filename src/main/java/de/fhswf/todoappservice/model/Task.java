package de.fhswf.todoappservice.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private Project project;

    @ManyToOne
    private Status status;

    private String title;

    private String description;

    private Date dueDate;

    @Column(columnDefinition = "boolean default false")
    private boolean completed;

    private Date completedDate;

    @CreatedDate
    private Date created;

    @LastModifiedDate
    private Date updated;

}
