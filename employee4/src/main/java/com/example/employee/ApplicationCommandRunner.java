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

		logger.info("Welcome to the runner from commandLineRunner to test faker JAVA");
		logger.info("Data creation Employee started...");
		
		Faker faker = new Faker();
		
		for (int i = 1; i <101; i++) {
		
			System.out.println(new Employee (
					"EMP00" + i , 
					faker.name().firstName(),  
					faker.name().lastName(), 
					faker.number().numberBetween(18, 65))
					);
			
			
		
		}
		
		
         
	}	

}
