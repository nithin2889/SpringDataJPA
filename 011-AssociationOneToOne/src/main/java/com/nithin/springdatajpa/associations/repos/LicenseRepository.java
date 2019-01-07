package com.nithin.springdatajpa.associations.repos;

import org.springframework.data.repository.CrudRepository;

import com.nithin.springdatajpa.associations.entities.License;

public interface LicenseRepository extends CrudRepository<License, Long> {
	
}