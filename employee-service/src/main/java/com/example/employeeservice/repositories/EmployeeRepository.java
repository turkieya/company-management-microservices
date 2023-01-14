package com.example.employeeservice.repositories;

import com.example.employeeservice.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface
EmployeeRepository extends JpaRepository<Employee,Long> {
}
