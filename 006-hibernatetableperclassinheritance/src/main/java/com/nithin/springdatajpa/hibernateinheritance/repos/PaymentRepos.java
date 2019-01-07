package com.nithin.springdatajpa.hibernateinheritance.repos;

import org.springframework.data.repository.CrudRepository;

import com.nithin.springdatajpa.hibernateinheritance.entities.Payment;

public interface PaymentRepos extends CrudRepository<Payment, Integer> {
	
}