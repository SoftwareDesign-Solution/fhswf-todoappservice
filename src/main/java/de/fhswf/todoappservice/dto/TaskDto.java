package de.fhswf.todoappservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.fhswf.todoappservice.model.Project;
import de.fhswf.todoappservice.model.Status;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Data
public class TaskDto {

    private Integer id;

    //private Integer projectId;

    //private String project;

    private ProjectDto project;

    //private Integer statusId;

    private StatusDto status;

    //private Integer priorityId;

    private PriorityDto priority;

    private String title;

    private String description;

    private Date dueDate;

    private boolean completed;

    private Date completedDate;

    private Date startDate;

    private Date endDate;

    private Date created;

    private Date updated;

    TaskDto() {
        this.project = new ProjectDto();
        this.status = new StatusDto();
        this.priority = new PriorityDto();
    }

}
