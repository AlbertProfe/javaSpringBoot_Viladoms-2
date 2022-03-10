package com.example.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	

	@Autowired
	EmployeeRepository employeeRepository;

	//CRUD basic operations
	public Iterable<Employee> findAll() {
		
		return employeeRepository.findAll();
	}

	public Employee save(Employee employee) {
		employeeRepository.save(employee);

		return employee;
	}


	public void deleteById(String id) {

		employeeRepository.deleteById(id);
	}


	public long count() {
		long quantity = employeeRepository.count();

		return quantity;
	}

	
	public Employee findItemByName(String name) {
		
		Employee employeeFound = employeeRepository.findItemByName(name);
		
		return employeeFound;
	}

	public void deleteAll() {
		employeeRepository.deleteAll();
		
	}




}
