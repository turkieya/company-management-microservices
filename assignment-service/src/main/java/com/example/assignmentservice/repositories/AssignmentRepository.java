package com.example.assignmentservice.repositories;

import com.example.assignmentservice.entities.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface AssignmentRepository extends JpaRepository<Assignment,Long> {
    @RestResource(path = "/byEmployeeId")
    List<Assignment> findByEmployeeId(@Param("employeeId") Long employeeId);

}
