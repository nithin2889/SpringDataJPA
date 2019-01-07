package com.nithin.springdatajpa.associations.repos;

import org.springframework.data.repository.CrudRepository;

import com.nithin.springdatajpa.associations.entities.Programmer;

public interface ProgrammerRepository extends CrudRepository<Programmer, Integer> {
	
}