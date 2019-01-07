package com.nithin.springdatajpa.componentmapping;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.nithin.springdatajpa.componentmapping.entities.Address;
import com.nithin.springdatajpa.componentmapping.entities.Employee;
import com.nithin.springdatajpa.componentmapping.repos.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ComponentmappingApplicationTests {

	@Autowired
	EmployeeRepository er;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createEmployee() {
		Employee emp = new Employee();
		emp.setId(122);
		emp.setName("Nithin");
		
		Address address = new Address();
		address.setStreetaddress("10th main");
		address.setCity("Bangalore");
		address.setState("Karnataka");
		address.setZipcode("560061");
		address.setCountry("India");
		
		emp.setAddress(address);
		er.save(emp);
	}

}