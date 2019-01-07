package com.nithin.springdatajpa.associations.repos;

import org.springframework.data.repository.CrudRepository;

import com.nithin.springdatajpa.associations.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
}