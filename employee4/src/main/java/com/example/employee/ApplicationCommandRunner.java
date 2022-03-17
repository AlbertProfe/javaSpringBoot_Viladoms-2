package com.example.employee;


import java.util.List;

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
		
		//createEmployee();
		
		List<Employee> employees = employeeRepository.findItemByAge(50);
		
		System.out.println ("employees greater than 50: " + employees.size());
		System.out.println("Employees: \n" + employees );
		
		employees.clear();
		
		employees = employeeRepository.findItemBySurname("Cormier");
		
		System.out.println ("employees surname Cormier: " + employees.size());
		System.out.println("Employees: \n" + employees );
		
		
		  employees.clear();
		  
		  employees = employeeRepository.findItemByAgeAndSurname(40, "Cormier");
		  
		  System.out.println ("employees age gt 40 and surname Cormier: " +
		  employees.size()); System.out.println("Employees: \n" + employees );
		 
		
		
		}
		
		public void createEmployee() {
			employeeRepository.deleteAll();
			
			Faker faker = new Faker();
			
			for (int i = 1; i <51; i++) {
			
				
				employeeRepository.save(new Employee (
											"EMP00" + i , 
											faker.name().firstName(),  
											faker.name().lastName(), 
											faker.number().numberBetween(18, 65))
											);
			
		}
		
		
         
	}	

}
