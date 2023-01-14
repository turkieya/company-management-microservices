package com.example.employeeservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "fullEmployee",types = Employee.class)
public interface EmployeeProjection {
    public Long getId();
    public String getFirstName();
    public String getLastName();
    public String getEmail();
    public Long getTel();
    public Departement getDepartement();
    public String getPoste();

}
