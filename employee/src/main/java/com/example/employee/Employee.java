package com.example.employee;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("employee")
public class Employee {

        @Id
        private String id;

        private String name;
        private String surname;
        private int age;
        
        public Employee(String id, String name, String surname, int age) {
            super();
            this.id = id;
            this.name = name;
 	        this.surname = surname;
            this.age = age;
           
        }
}