package com.nithin.springdatajpa.product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.nithin.springdatajpa.product.entities.Product;
import com.nithin.springdatajpa.product.repo.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductdataApplicationTests {
	
	@Autowired
	ProductRepository repo;

	@Autowired
	EntityManager entityManager;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testCreate() {
		Product product = new Product();
		product.setId(1);
		product.setName("IPhone");
		product.setDesc("Very Good");
		product.setPrice(1000d);
		
		repo.save(product);
	}
	
	@Test
	public void testRead() {
		Product product = repo.findById(1).get();
		assertNotNull(product);
		assertEquals("iPhone", product.getName());
		System.out.println("Name>>>>>>>>>>>>>>>>>>>>>>>>" +product.getName());
	}
	
	@Test
	public void testUpdate() {
		Optional<Product> product = repo.findById(1);
		Product toUpdate = product.get();
		toUpdate.setPrice(1200d);
		repo.save(toUpdate);
	}
	
	@Test
	public void testDelete() {
		if(repo.existsById(3)) {
			System.out.println("Deleting a record");
			repo.deleteById(3);
		} else {
			System.out.println("Record doesn't exist");
		}
	}
	
	@Test
	public void testCount() {
		System.out.println("Total=>>>>>>>>>>>>>>>>>>>>"+repo.count());
	}
	
	@Test
	public void testFindByName() {
		List<Product> products = repo.findByName("Washer");
		products.forEach(p -> System.out.println(p.getName() + " costs $" + p.getPrice()));
	}
	
	@Test
	public void testFindByNameAndDesc() {
		List<Product> products = repo.findByNameAndDesc("Washer", "From LG Inc.");
		products.forEach(p -> System.out.println(p.getName() + " is " + p.getDesc()));
	}
	
	@Test
	public void testFindByPriceGreaterThan() {
		List<Product> products = repo.findByPriceGreaterThan(900d);
		products.forEach(p -> System.out.println(p.getName() + " "));
	}
	
	@Test
	public void testFindByDescContains() {
		List<Product> products = repo.findByDescContains("Samsung");
		products.forEach(p -> System.out.println(p.getName()));
	}
	
	@Test
	public void testFindByPriceBetween() {
		List<Product> products = repo.findByPriceBetween(1000d, 3000d);
		products.forEach(p -> System.out.println(p.getName() + "-" + p.getPrice()));
	}
	
	@Test
	public void testFindByDescLike() {
		List<Product> products = repo.findByDescLike("%LG%");
		products.forEach(p -> System.out.println(p.getName()));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testFindByIdIn() {
		Pageable pageable = new PageRequest(1, 2);
		List<Product> products = repo.findByIdIn(Arrays.asList(1, 2, 3, 4), pageable);
		products.forEach(p -> System.out.println(p.getName()));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testFindAllPaging() {
		Pageable pageable = new PageRequest(0, 1);
		Page<Product> results = repo.findAll(pageable);
		results.forEach(p -> System.out.println(p.getName()));
	}
	
	@Test
	public void testFindAllMultiplePropertiesSorting() {
		repo.findAll(new Sort(Direction.DESC, "name", "price")).forEach(p -> System.out.println(p.getName()));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testFindAllMultiplePropertiesAndDirectionsSorting() {
		repo.findAll(new Sort(new Sort.Order(Direction.DESC, "name"), new Sort.Order("price")));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testFindAllPagingAndSorting() {
		Pageable pageable = new PageRequest(0, 2, Direction.DESC, "name");
		repo.findAll(pageable).forEach(p -> System.out.println(p.getName()));
	}
	
	@Test
	@Transactional
	public void testCaching() {
		Session session = entityManager.unwrap(Session.class);
		Product product = repo.findById(1).get();
		
		repo.findById(1);
		
		session.evict(product);
		
		repo.findById(1);
	}

}