package com.example.employee;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.github.javafaker.Faker;

@SpringBootTest
class EmployeeApplicationTests {
	
	@Autowired
	EmployeeService employeeService;

	 @Test
	 void testCreateCustomer() {
		 Employee employee = new Employee();
		 employee.setId("EMP000");
		 employee.setName("Joan");
		 employee.setSurname("Jones");
		 employee.setAge(25);
		 employeeService.save(employee);
	  }
	 
	 @Test
	 void testCreateCustomers() {
		 Faker faker = new Faker();
		 for (int i = 2; i <51; i++) {
			 Employee employee = new Employee();
			 employee.setId("EMP00" + i);
			 employee.setName(faker.name().firstName());
			 employee.setSurname(faker.name().lastName());
			 employee.setAge(faker.number().numberBetween(18, 65));
			 employeeService.save(employee);
		 }
	 
	 }
	 
	 @Test
	 void testDeleteAllCustomers() { 
		 employeeService.deleteAll();
	 }
}