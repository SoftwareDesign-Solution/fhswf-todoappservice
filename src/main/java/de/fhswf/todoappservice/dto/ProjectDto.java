package de.fhswf.todoappservice.dto;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Data
public class ProjectDto {

    private Integer id;

    private String name;

    private Date created;

    private Date updated;

}
