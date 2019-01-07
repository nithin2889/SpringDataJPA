package com.nithin.springdatajpa.jpqlandnativesql;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.nithin.springdatajpa.jpqlandnativesql.entities.Student;
import com.nithin.springdatajpa.jpqlandnativesql.repos.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpqlandnativesqlApplicationTests {

	@Autowired
	StudentRepository sr;
	
	@Test
	public void testCreateStudent() {
		Student student1 = new Student();
		student1.setFirstName("Nithin");
		student1.setLastName("Prasad");
		student1.setScore(99);
		sr.save(student1);
		
		Student student2 = new Student();
		student2.setFirstName("Akhila");
		student2.setLastName("Martia");
		student2.setScore(88);
		sr.save(student2);
		
		Student student3 = new Student();
		student3.setFirstName("Jaden");
		student3.setLastName("Marlon");
		student3.setScore(55);
		sr.save(student3);
		
		Student student4 = new Student();
		student4.setFirstName("Christine");
		student4.setLastName("Marshall");
		student4.setScore(62);
		sr.save(student4);
		
		Student student5 = new Student();
		student5.setFirstName("Jon");
		student5.setLastName("Snow");
		student5.setScore(76);
		sr.save(student5);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testFindAllStudents() {
		System.out.println(sr.findAllStudents(new PageRequest(0, 2, Direction.DESC, "id")));
	}
	
	@Test
	public void testFindAllStudentsPartialData() {
		List<Object[]> partialData = sr.findAllStudentsPartialData();
		for (Object objects[] : partialData) {
			System.out.println(objects[0] + " " + objects[1]);
		}
	}
	
	@Test
	public void testFindAllStudentsByFirstName() {
		System.out.println(sr.findAllStudentsByFirstName("Nithin"));
	}
	
	@Test
	public void testFindAllStudentsByScores() {
		System.out.println(sr.findAllStudentsByGivenScores(50, 90));
	}
	
	@Test
	@Transactional
	@Rollback(value=false)
	public void testDeleteStudentsByFirstName() {
		sr.deleteStudentsByFirstName("Nithin");
	}
	
	@Test
	public void testFindAllStudentsNQ() {
		System.out.println(sr.findAllStudentsNQ());
	}
	
	@Test
	public void testFirstByFirstNameNQ() {
		System.out.println(sr.findByFirstNameNQ("Nithin"));
	}

}