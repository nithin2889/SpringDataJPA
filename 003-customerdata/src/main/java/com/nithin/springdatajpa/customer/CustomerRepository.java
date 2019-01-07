package com.nithin.springdatajpa.customer;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.nithin.springdatajpa.customer.entities.Customer;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Integer> {
	List<Customer> findByEmailAndName(String email, String name);

	List<Customer> findByEmailLike(String email);

	List<Customer> findByIdIn(List<Integer> ids);
	
	@Query("from Customer")
	List<Customer> findAllCustomer(Pageable pageable);
	
	@Modifying
	@Query("update Customer c set c.email=:email where c.id=:id")
	void updateCustomerEmailByIdAndEmail(@Param(value="id") int id, @Param(value="email") String email);
}