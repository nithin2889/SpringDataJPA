package com.nithin.springdatajpa.product.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nithin.springdatajpa.product.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
	List<Product> findByName(String name);

	List<Product> findByNameAndDesc(String name, String desc);

	List<Product> findByPriceGreaterThan(Double price);

	List<Product> findByDescContains(String desc);

	List<Product> findByPriceBetween(Double one, Double two);

	List<Product> findByDescLike(String desc);

	List<Product> findByIdIn(List<Integer> ids);
}