package com.example.assignmentservice.services;

import com.example.assignmentservice.entities.Assignment;
import com.example.assignmentservice.models.Employee;
import com.example.assignmentservice.models.Project;
import com.example.assignmentservice.repositories.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssignmentService {
    @Autowired
    AssignmentRepository AssignmentRepo;
    @Autowired
    private EmployeeRestClientService employeeRestClientService;
    @Autowired
    private ProjectRestClientService projectRestClientService;

    public Assignment saveAssignment(Assignment assignment) {
        Employee employee=employeeRestClientService.employeeById(assignment.getEmployeeId());
        assignment.setEmployee(employee);
        Project project=projectRestClientService.projectById(assignment.getProjectId());
        assignment.setProject(project);
        AssignmentRepo.save(assignment);

        return assignment;
    }
}
