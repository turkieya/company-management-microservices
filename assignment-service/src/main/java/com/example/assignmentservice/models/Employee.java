package com.example.assignmentservice.models;

import lombok.Data;

@Data
public class Employee {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private long tel;
    private Departement departement;
    private String poste;
}
