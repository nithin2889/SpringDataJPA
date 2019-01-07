package com.nithin.springdatajpa.idgenerators.repos;

import org.springframework.data.repository.CrudRepository;

import com.nithin.springdatajpa.idgenerators.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	
}