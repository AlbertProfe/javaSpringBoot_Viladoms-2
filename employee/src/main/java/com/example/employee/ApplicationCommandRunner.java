package com.example.employee;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;

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
		employeeRepository.save(new Employee("Joan", "Jones", 25));
		employeeRepository.save(new Employee("Anna", "Williams", 28));
		employeeRepository.save(new Employee("Pere", "Williams", 28));
       
        logger.info("Data creation Employee complete...");
        
        List<Employee> employees = employeeRepository.findAll();
        
        logger.info("Data Employee query get " + employees);
        
        
        logger.info("employees count: " + employeeRepository.count());
        
        Employee employeeFound = employeeRepository.findItemByName("Pere");
        logger.info("employees Pere" + employeeFound);
        employeeRepository.deleteById( employeeFound.getId() );
        
        
        employeeRepository.deleteById("62277a52b0dcbc035e1f3e2c");
        
       // logger.info
        
     
	}	

}
