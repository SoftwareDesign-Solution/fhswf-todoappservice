package de.fhswf.todoappservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //@ManyToOne
    //@JsonIgnore
    @OneToOne
    @JoinColumn(name = "project", referencedColumnName = "id")
    @JsonIgnoreProperties({"tasks"})
    private Project project;

    @OneToOne
    @JoinColumn(name = "status", referencedColumnName = "id")
    @JsonIgnoreProperties({"tasks"})
    private Status status;

    @OneToOne
    @JoinColumn(name = "priority", referencedColumnName = "id")
    @JsonIgnoreProperties({"tasks"})
    private Priority priority;

    private String title;

    private String description;

    @Temporal(TemporalType.DATE)
    private Date dueDate;

    @Column(columnDefinition = "boolean default false")
    private boolean completed;

    @Temporal(TemporalType.DATE)
    private Date completedDate;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;

    @CreatedDate
    private Date created;

    @LastModifiedDate
    private Date updated;

}
