package com.example.assignmentservice.repositories;

import com.example.assignmentservice.entities.Status;
import com.example.assignmentservice.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Date;

@RepositoryRestResource
public interface TaskRepository extends JpaRepository<Task,Long> {

    @Modifying
    @Query("update Task t set t.description=:description,t.status=:status,t.start_date=:start_date,t.end_date=:end_date where t.id=:id")
    void edit(@Param("id") Long id, @Param("description") String description, @Param("status") Status status, @Param("start_date") Date start_date,@Param("end_date") Date end_date);

}
