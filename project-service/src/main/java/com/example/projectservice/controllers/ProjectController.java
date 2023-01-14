package com.example.projectservice.controllers;

import com.example.projectservice.entities.Project;
import com.example.projectservice.entities.Status;
import com.example.projectservice.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    ProjectService projectService;

   // @PreAuthorize("hasAuthority('manager')")
    @PostMapping(path="/add")
    public Project addProject(@RequestBody Project proj) {
        return projectService.saveProject(proj);
    }

    @GetMapping(path = "/status")
    public List getStatus(){
        List<Status> status =new ArrayList<Status>();
        status.add(Status.PENDING);
        status.add(Status.COMPLETED);
        status.add(Status.CANCELED);
        return status;
    }
}
