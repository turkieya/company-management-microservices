package com.example.assignmentservice.entities;

import com.example.assignmentservice.models.Employee;
import com.example.assignmentservice.models.Project;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Assignment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private Long employeeId;
    @Transient
    private Employee employee;
    private Long projectId;
    @Transient
    private Project project;
    @OneToMany(mappedBy = "assignment")
    private List<Task> tasks;


}
