package com.nithin.springdatajpa.customer;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.nithin.springdatajpa.customer.CustomerRepository;
import com.nithin.springdatajpa.customer.entities.Address;
import com.nithin.springdatajpa.customer.entities.Customer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerdataApplicationTests {

	@Autowired
	CustomerRepository cr;

	@Test
	public void testCreateCustomer() {
		Customer customer = new Customer();
		customer.setName("Nithin");
		customer.setEmail("nithin@gmail.com");
		cr.save(customer);
	}

	@Test
	public void testReadCustomer() {
		Customer customer = cr.findById(1).get();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>" + customer);
	}

	@Test
	public void testUpdateCustomer() {
		Customer customer = cr.findById(1).get();
		customer.setName("Akhila");
		customer.setEmail("akhila@gmail.com");
		cr.save(customer);
	}

	@Test
	public void testDeleteCustomer() {
		cr.deleteById(1);
	}

	@Test
	public void testFindByEmailAndName() {
		List<Customer> customer = cr.findByEmailAndName("nithin@gmail.com", "Nithin");
		customer.forEach(c -> System.out.println(c.getName()));
	}

	@Test
	public void testFindByEmailLike() {
		List<Customer> customer = cr.findByEmailLike("%chrystal%");
		customer.forEach(c -> System.out.println(c.getName() + "-" + c.getEmail()));
	}

	@Test
	public void testFindByIdIn() {
		List<Customer> customer = cr.findByIdIn(Arrays.asList(1, 3, 4));
		customer.forEach(c -> System.out.println(c.getName() + "-" + c.getEmail()));
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testFindAllByPaging() {
		Pageable pageable = new PageRequest(0, 2);
		Page<Customer> results = cr.findAll(pageable);
		results.forEach(p -> System.out.println(p.getName()));
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testFindAllBySorting() {
		cr.findAll(new Sort(Direction.DESC, "name", "email"))
				.forEach(p -> System.out.println(p.getName() + "-" + p.getEmail()));
		// cr.findAll(new Sort(new Sort.Order(Sort.Direction.DESC, "name"), new Sort.Order(Direction.ASC, "email")));
		cr.findAll(new Sort(new Sort.Order(Sort.Direction.DESC, "name"), new Sort.Order(Sort.Direction.ASC, "email")));
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testFindAllByPageableAndSorting() {
		Pageable pageable = new PageRequest(0, 2, Direction.DESC, "name");
		cr.findAll(pageable).forEach(p -> System.out.println(p.getName() + "-" + p.getEmail()));
	}

	@Test
	@Transactional
	@Rollback(value = false)
	public void testUpdateCustomerEmail() {
		cr.updateCustomerEmailByIdAndEmail(3, "chrystie@hotmail.com");
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testFindAllCustomers() {
		System.out.println(cr.findAllCustomer(new PageRequest(1, 5, Direction.DESC, "name")));
	}

	@Test
	public void testCreateEmbeddedCustomer() {
		Customer cust = new Customer();
		cust.setName("Nithin");
		cust.setEmail("nithin@gmail.com");

		Address address = new Address();
		address.setStreetaddress("18th Main");
		address.setCity("Bengaluru");
		address.setState("Karnataka");
		address.setZipcode("560061");
		address.setCountry("India");

		cust.setAddress(address);

		cr.save(cust);
	}

}