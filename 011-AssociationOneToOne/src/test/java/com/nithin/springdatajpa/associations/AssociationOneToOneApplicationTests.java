package com.nithin.springdatajpa.associations;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.nithin.springdatajpa.associations.entities.License;
import com.nithin.springdatajpa.associations.entities.Person;
import com.nithin.springdatajpa.associations.repos.LicenseRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AssociationOneToOneApplicationTests {

	@Autowired
	LicenseRepository lr;
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void testOneToOneCreateLicense() {
		License license = new License();
		license.setType("DMV");
		license.setValidFrom(new Date());
		license.setValidTo(new Date());
		
		Person person = new Person();
		person.setFirstName("Nithin");
		person.setLastName("Prasad");
		person.setAge(29);
		
		license.setPerson(person);
		
		lr.save(license);
	}
	
}