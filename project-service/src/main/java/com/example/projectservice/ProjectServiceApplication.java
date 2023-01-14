package com.example.projectservice;

import com.example.projectservice.entities.Project;
import com.example.projectservice.entities.Status;
import com.example.projectservice.repositories.ProjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class ProjectServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectServiceApplication.class, args);
	}

	/*@Bean
	CommandLineRunner start(ProjectRepository projectRepository){
		return args -> {
			for (int i = 1; i <4 ; i++) {
				projectRepository.saveAll(List.of(
						Project.builder()
								.name("Project "+i)
								.status(Status.PENDING)
								.start_date(new Date()).build()
				));
			}

		};
	}*/

}
