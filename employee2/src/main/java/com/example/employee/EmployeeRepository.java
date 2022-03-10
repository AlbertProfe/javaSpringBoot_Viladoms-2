package com.example.employee;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
    
    @Query("{name:'?0'}")
    Employee findItemByName(String name);
    
    @Query(value="{category:'?0'}", fields="{'name' : 1, 'age' : 1}")
    List<Employee> findAll(String surname);
    


    
}