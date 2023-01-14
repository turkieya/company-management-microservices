package com.example.employeeservice.services;

import com.example.employeeservice.entities.Employee;
import com.example.employeeservice.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository EmployeeRepo;

    public Employee saveEmployee(Employee emp) {
        EmployeeRepo.save(emp);
        return emp;
    }
}
