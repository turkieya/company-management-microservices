package com.example.projectservice.repositories;

import com.example.projectservice.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource
public interface ProjectRepository extends JpaRepository<Project,Long>  {
    @Query("select emp from Project emp")
    List<Project> getProjects();
}
