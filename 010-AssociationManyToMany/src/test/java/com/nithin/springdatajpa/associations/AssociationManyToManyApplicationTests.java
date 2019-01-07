package com.nithin.springdatajpa.associations;

import java.util.HashSet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.nithin.springdatajpa.associations.entities.Programmer;
import com.nithin.springdatajpa.associations.entities.Project;
import com.nithin.springdatajpa.associations.repos.ProgrammerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AssociationManyToManyApplicationTests {

	@Autowired
	ProgrammerRepository pr;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testMToMCreateProgrammer() {
		Programmer prog = new Programmer();
		prog.setName("Nithin");
		prog.setSal(86000);
		
		HashSet<Project> projects = new HashSet<>();
		Project project = new Project();
		project.setName("IBM RO");
		
		projects.add(project);
		
		prog.setProjects(projects);
		pr.save(prog);
	}
	
	@Test
	@Transactional
	public void testMToMLoadProgrammer() {
		Programmer programmer = pr.findById(1).get();
		System.out.println(programmer);
		System.out.println(programmer.getProjects());
	}

}