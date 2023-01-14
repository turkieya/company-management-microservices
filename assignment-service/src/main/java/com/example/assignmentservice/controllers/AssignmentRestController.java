package com.example.assignmentservice.controllers;

import com.example.assignmentservice.entities.Assignment;
import com.example.assignmentservice.models.Employee;
import com.example.assignmentservice.models.Project;
import com.example.assignmentservice.repositories.AssignmentRepository;
import com.example.assignmentservice.repositories.TaskRepository;
import com.example.assignmentservice.services.AssignmentService;
import com.example.assignmentservice.services.EmployeeRestClientService;
import com.example.assignmentservice.services.ProjectRestClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignment")
public class AssignmentRestController {
    @Autowired
    private AssignmentRepository assignmentRepository;
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private EmployeeRestClientService employeeRestClientService;
    @Autowired
    private ProjectRestClientService projectRestClientService;

    @Autowired
    private AssignmentService assignmentService;

    //@PreAuthorize("hasAuthority('manager')")
    @PostMapping(path="/add")
    public Assignment addAssignment(@RequestBody Assignment ass) {
        return assignmentService.saveAssignment(ass);
    }

    //@PreAuthorize("hasAuthority('employee')")
    @GetMapping("/fullAssignment/{id}")
    public Assignment getAssignment(@PathVariable Long id){
        Assignment assignment = assignmentRepository.findById(id).get();
        Employee employee=employeeRestClientService.employeeById(assignment.getEmployeeId());
        assignment.setEmployee(employee);
        Project project=projectRestClientService.projectById(assignment.getProjectId());
        assignment.setProject(project);

        return assignment;
    }
   // @PreAuthorize("hasAuthority('manager')")
    @GetMapping("/AllAssignments")
    public List<Assignment> getAllAssignments(){
        List<Assignment> assignments= assignmentRepository.findAll();
        for(int i=0;i<assignments.size();i++){
            Employee employee=employeeRestClientService.employeeById(assignments.get(i).getEmployeeId());
            assignments.get(i).setEmployee(employee);
            Project project=projectRestClientService.projectById(assignments.get(i).getProjectId());
            assignments.get(i).setProject(project);
        }
        return assignments;
    }
    //@PreAuthorize("hasAuthority('employee')")
    @GetMapping("/fullAssignmentByemp/{id}")
    public List<Assignment> getAssignmentByEmployee(@PathVariable Long id){
        List<Assignment> assignments=assignmentRepository.findByEmployeeId(id);
        for (int i=0;i<assignments.size();i++){
        Employee employee=employeeRestClientService.employeeById(assignments.get(i).getEmployeeId());
        assignments.get(i).setEmployee(employee);
        Project project=projectRestClientService.projectById(assignments.get(i).getProjectId());
        assignments.get(i).setProject(project);
        }

        return assignments;
    }
}
