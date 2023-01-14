package com.example.employeeservice.controllers;

import com.example.employeeservice.entities.Departement;
import com.example.employeeservice.entities.Employee;
import com.example.employeeservice.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService empService;

  //  @PreAuthorize("hasAuthority('manager')")
    @PostMapping(path="/add")
    public Employee addEmployee(@RequestBody Employee emp) {
        return empService.saveEmployee(emp);
    }

    @GetMapping(path = "/depatements")
    public List getdep(){
        List<Departement> dept=new ArrayList<Departement>();
        dept.add(Departement.RH);
        dept.add(Departement.IT);
        dept.add(Departement.SALES);
        return dept;
    }
}
