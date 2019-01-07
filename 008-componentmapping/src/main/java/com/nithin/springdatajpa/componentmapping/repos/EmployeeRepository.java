package com.nithin.springdatajpa.componentmapping.repos;

import org.springframework.data.repository.CrudRepository;

import com.nithin.springdatajpa.componentmapping.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	
}