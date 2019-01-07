package com.nithin.springdatajpa.associations;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.nithin.springdatajpa.associations.entities.Customer;
import com.nithin.springdatajpa.associations.entities.PhoneNumber;
import com.nithin.springdatajpa.associations.repos.CustomerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AssociationOneToManyAndManyToOneApplicationTests {

	@Autowired
	CustomerRepository cr;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testCreateCustomer() {
		Customer cust = new Customer();
		cust.setName("Nithin");
		
		PhoneNumber ph1 = new PhoneNumber();
		ph1.setNumber("121323424");
		ph1.setType("cell");
		
		PhoneNumber ph2 = new PhoneNumber();
		ph2.setNumber("712691999");
		ph2.setType("home");
		
		cust.addNumbers(ph1);
		cust.addNumbers(ph2);
		
		cr.save(cust);
	}
	
	@Test
	@Transactional
	public void testLoadCustomer() {
		Customer customer = cr.findById(3L).get();
		System.out.println(customer.getName());
		
		Set<PhoneNumber> numbers = customer.getNumbers();
		numbers.forEach(number->System.out.println(number.getNumber()));
	}
	
	@Test
	@Rollback(value=false)
	public void testUpdateCustomer() {
		Customer customer = cr.findById(6L).get();
		customer.setName("Akhila");
		
		Set<PhoneNumber> numbers = customer.getNumbers();
		numbers.forEach(number->number.setType("cell"));
		
		cr.save(customer);
	}
	
	@Test
	public void testDeleteCustomer() {
		Customer customer = cr.findById(2L).get();
		cr.delete(customer);
	}

}