package com.example.assignmentservice;

import com.example.assignmentservice.entities.Assignment;
import com.example.assignmentservice.entities.Status;
import com.example.assignmentservice.entities.Task;
import com.example.assignmentservice.models.Employee;
import com.example.assignmentservice.models.Project;
import com.example.assignmentservice.repositories.AssignmentRepository;
import com.example.assignmentservice.repositories.TaskRepository;
import com.example.assignmentservice.services.EmployeeRestClientService;
import com.example.assignmentservice.services.ProjectRestClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class AssignmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentServiceApplication.class, args);
	}

	/*@Bean
	CommandLineRunner start(AssignmentRepository assignmentRepository,
							TaskRepository taskRepository,
							EmployeeRestClientService employeeRestClientService,
							ProjectRestClientService projectRestClientService){
		return args -> {
			List<Employee> employees=employeeRestClientService.allEmployees().getContent().stream().toList();
			List<Project> projects=projectRestClientService.allProjects().getContent().stream().toList();
			Random random=new Random();
			for (int i=0;i<5;i++){
				Assignment assignment = Assignment.builder()
						.employeeId(employees.get(random.nextInt(employees.size())).getId())
						.projectId(projects.get(random.nextInt(projects.size())).getId())
						.date(new Date())
						.build();
				Assignment savedAssignment=assignmentRepository.save(assignment);
				for(int j=0;j<3;j++){
					Task task= Task.builder()
							.start_date(new Date())
							.assignment(savedAssignment)
							.statut(Status.PENDING)
							.description("d"+random)
							.build();
					taskRepository.save(task);
				}
			}

		};
	}*/
}
