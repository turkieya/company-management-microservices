package com.example.projectservice.services;

import com.example.projectservice.entities.Project;
import com.example.projectservice.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    ProjectRepository ProjectRepo;

    public Project saveProject(Project project) {
        ProjectRepo.save(project);
        return project;
    }
    public List<Project> getAllEmployee() {
        return ProjectRepo.getProjects();
    }

}
