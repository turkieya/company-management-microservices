package com.example.assignmentservice.services;

import com.example.assignmentservice.models.Project;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "project-service")
public interface ProjectRestClientService {
    @GetMapping("/projects/{id}?projection=fullProject")
    public Project projectById(@PathVariable Long id);

    @GetMapping("/projects?projection=fullProject")
    public PagedModel<Project> allProjects();
}
