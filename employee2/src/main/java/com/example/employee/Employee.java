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
        
        public Employee () {}
        
        public Employee(String id, String name, String surname, int age) {
            super();
            this.id = id;
            this.name = name;
 	        this.surname = surname;
            this.age = age;
           
        }

		public Employee(String name, String surname, int age) {
			super();
            this.name = name;
 	        this.surname = surname;
            this.age = age;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getSurname() {
			return surname;
		}

		public void setSurname(String surname) {
			this.surname = surname;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + ", surname=" + surname + ", age=" + age + "]";
		}
        
		
        
}