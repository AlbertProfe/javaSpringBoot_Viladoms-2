package com.example.employee;

import java.sql.Timestamp;
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
		
		Timestamp startCreate20 = new Timestamp(System.currentTimeMillis());
		employeeRepository.save(new Employee("Joan", "Jones", 25));
		employeeRepository.save(new Employee("Anna", "Williams", 28));
		employeeRepository.save(new Employee("Pere", "Williams Sarger", 28));
		employeeRepository.save(new Employee("Pere", "Williams Sarger", 28));
		employeeRepository.save(new Employee("Pere", "Williams Sarger", 28));
		employeeRepository.save(new Employee("Pere", "Williams Sarger", 28));
		employeeRepository.save(new Employee("Pere", "Williams Sarger", 28));
		employeeRepository.save(new Employee("Joan", "Jones", 25));
		employeeRepository.save(new Employee("Anna", "Williams", 28));
		employeeRepository.save(new Employee("Joan", "Jones", 25));
		employeeRepository.save(new Employee("Anna", "Williams", 28));
		employeeRepository.save(new Employee("Joan", "Jones", 25));
		employeeRepository.save(new Employee("Anna", "Williams", 28));
		employeeRepository.save(new Employee("Joan", "Jones", 25));
		employeeRepository.save(new Employee("Anna", "Williams", 28));
		employeeRepository.save(new Employee("Joan", "Jones", 25));
		employeeRepository.save(new Employee("Anna", "Williams", 28));
		employeeRepository.save(new Employee("Joan", "Jones", 25));
		employeeRepository.save(new Employee("Anna", "Williams", 28));
		employeeRepository.save(new Employee("Joan", "Jones", 25));
		Timestamp finishCrete20 = new Timestamp(System.currentTimeMillis());
		
		logger.info("duration create 20 operation ... (ms)" + (startCreate20.getTime() - finishCrete20.getTime()));
        logger.info("Data creation Employee complete...");
        
        List<Employee> employees = employeeRepository.findAll();
        logger.info("Data Employee query get " + employees);
        logger.info("employees count: " + employeeRepository.count());
        
        Timestamp startCreate = new Timestamp(System.currentTimeMillis());
        employeeRepository.save(new Employee("Silvia", "Williams", 28));
        Timestamp finishCreate = new Timestamp(System.currentTimeMillis());
        
        Timestamp startFind = new Timestamp(System.currentTimeMillis());
        Employee employeeFound = employeeRepository.findItemByName("Silvia");
        Timestamp finishFind = new Timestamp(System.currentTimeMillis());
        logger.info("employees Pere" + employeeFound);
        
        employeeRepository.deleteById( employeeFound.getId() );
        Timestamp deleteOperation = new Timestamp(System.currentTimeMillis());
        
        logger.info("duration create operation ... (ms)" + (startCreate.getTime() - finishCreate.getTime()));
        logger.info("duration find ... (ms)" + (startFind.getTime() - finishFind.getTime()));
        logger.info("duration delete operation ... (ms)" + (finishFind.getTime() - deleteOperation.getTime()));
        
        employeeRepository.deleteById("62277a52b0dcbc035e1f3e2c");
         
        Timestamp startDelete = new Timestamp(System.currentTimeMillis());
        employeeRepository.deleteAll();
        Timestamp finishDelete = new Timestamp(System.currentTimeMillis());
        logger.info("duration delete all operation ... (ms)" + (startDelete.getTime() - finishDelete.getTime()));
         
        employeeRepository.save(new Employee("Teresa", "Williams", 58));
        Timestamp startUpdate = new Timestamp(System.currentTimeMillis());
        employeeFound = employeeRepository.findItemByName("Teresa");
        employeeFound.setAge(59);
        employeeRepository.save(employeeFound);
        Timestamp finishUpdate = new Timestamp(System.currentTimeMillis());
        logger.info("duration update operation ... (ms)" + (startUpdate.getTime() - finishUpdate.getTime()));
        employeeFound = employeeRepository.findItemByName("Teresa");
        logger.info("update Teresa from age 58 to 59 ..." + employeeFound);
         
	}	

}
