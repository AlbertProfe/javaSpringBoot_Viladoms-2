package com.example.employee;

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
	EmployeeService employeeService;

	@Override
	public void run(String... args) throws Exception {

		logger.info("Welcome to the runner from commandLineRunner to test JPA mapping 1:n");
		
		
		//CRUD: read and create operations
		logger.info("Data creation Employee started...");
		employeeService.save(new Employee("Joan", "Jones", 25));
		employeeService.save(new Employee("Anna", "Williams", 28));
		employeeService.save(new Employee("Pere", "Williams Sarger", 28));
		employeeService.save(new Employee("Silvia", "Williams", 28));
        logger.info("Data creation Employee complete...");
        
        Iterable<Employee> employees = employeeService.findAll();
        logger.info("Data Employee query get " + employees);
        logger.info("employees count: " + employeeService.count());
        
        //CRUD: find and delete operations
        //Employee employeeFound = employeeService.findItemByName("Silvia");
        //logger.info("employees Silvia" + employeeFound);
        //employeeService.deleteById( employeeFound.getId() );
       
        //employeeService.deleteById("62277a52b0dcbc035e1f3e2c");
        //employeeService.deleteAll();
        
        //CRUD: update operation
        employeeService.save(new Employee("Teresa", "Williams", 58));
        //employeeFound.setAge(59);
        //employeeService.save(employeeFound);
        //employeeFound = employeeService.findItemByName("Teresa");
        //logger.info("update Teresa from age 58 to 59 ..." + employeeFound);
         
	}	

}
