package com.example.employee;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;
import com.github.javafaker.Faker;

@Component
@EnableMongoRepositories
public class ApplicationCommandRunner implements CommandLineRunner {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {

		logger.info("Welcome to the runner from commandLineRunner to test JPA mapping 1:n");
		logger.info("Data creation Employee started...");
		
		Faker faker = new Faker();
		
		for (int i = 0; i <100; i++) {
		
			System.out.println("Name: " + faker.name().firstName());
		
		}
		
		
         
	}	

}
