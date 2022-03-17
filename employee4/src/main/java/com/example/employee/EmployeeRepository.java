package com.example.employee;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
    
    //query with age greater than 50 => $gt is greater than and ?0 is the parameter that the query gets
    @Query("{age: {$gt : ?0}}")
    List<Employee> findItemByAge(int age);
    
    //query with surname ?0 => parameter given by funcition
    @Query("{surname: ?0 }")
    List<Employee> findItemBySurname(String surname);
    
    
    @Query("{age: {$gt : ?0} , surname: ?1 }")
    List<Employee> findItemByAgeAndSurname(int age, String surname);

    
    @Query(value = "{age: {$gt : ?0}}", fields = "{'surname' : 0}" )
    List<Employee> findItemByAgeWithootSuranme(int age);

    
}