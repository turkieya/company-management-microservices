package com.example.assignmentservice.models;

import lombok.Data;

import java.util.Date;
@Data
public class Project {
    private Long id;
    private String name;
    private Status status;
    private Date start_date;
    private Date end_date;
}
