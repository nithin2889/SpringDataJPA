package com.nithin.springdatajpa.filedata.repo;

import org.springframework.data.repository.CrudRepository;

import com.nithin.springdatajpa.filedata.entities.Image;

public interface ImageRepository extends CrudRepository<Image, Long> {
	
}