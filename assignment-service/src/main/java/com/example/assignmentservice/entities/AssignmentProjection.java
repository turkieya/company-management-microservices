package com.example.assignmentservice.entities;

import com.example.assignmentservice.models.Project;
import org.springframework.data.rest.core.config.Projection;

import java.util.Date;
import java.util.List;

@Projection(name = "fullAssignment",types = Assignment.class)
public interface AssignmentProjection {
    Long getId();
    Date getDate();
    Long getEmployeeId();
    Long getProjectId();
    List getTasks();
    Project getProject();

}
