package com.example.assignmentservice.services;

import com.example.assignmentservice.models.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "employee-service")
public interface EmployeeRestClientService {
    @GetMapping("/employees/{id}?projection=fullEmployee")
    public Employee employeeById(@PathVariable Long id);

    @GetMapping("/employees?projection=fullEmployee")
    public PagedModel<Employee> allEmployees();
}
