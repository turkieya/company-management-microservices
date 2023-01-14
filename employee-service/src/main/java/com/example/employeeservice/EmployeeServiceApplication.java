package com.example.employeeservice;

import com.example.employeeservice.entities.Departement;
import com.example.employeeservice.entities.Employee;
import com.example.employeeservice.repositories.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class EmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}
/*@Bean
	CommandLineRunner start (EmployeeRepository employeeRepository){
		return  args -> {
			employeeRepository.saveAll(List.of(
					Employee.builder().firstName("eya").email("turki@gmail.com").departement(Departement.IT).build(),
					Employee.builder().firstName("ahmed").email("ahmed@gmail.com").departement(Departement.RH).build(),
					Employee.builder().firstName("arij").email("erij@gmail.com").departement(Departement.IT).build()
			));
			employeeRepository.findAll().forEach(System.out::println);
		};
	}*/
}
