package com.example.projectservice.entities;

import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(name = "fullProject",types=Project.class)
public interface ProjectProjection {
    public  Long getId();
    public String getName();
    public Status getStatus();
    public Date getStart_date();
    public Date getEnd_date();
}
