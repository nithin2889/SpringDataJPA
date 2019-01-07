package com.nithin.springdatajpa.idgenerators;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.nithin.springdatajpa.idgenerators.entities.Employee;
import com.nithin.springdatajpa.idgenerators.repos.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IdgeneratorsApplicationTests {

	@Autowired
	EmployeeRepository er;
	
	@Test
	public void testCreateEmployee() {
		Employee employee = new Employee();
		employee.setName("Nithin");
		er.save(employee);
	}

}