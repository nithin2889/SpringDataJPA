package com.nithin.springdatajpa.jpqlandnativesql.repos;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.nithin.springdatajpa.jpqlandnativesql.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

	@Query("from Student")
	List<Student> findAllStudents(Pageable pageable);

	@Query("select s.firstName, s.lastName from Student s")
	List<Object[]> findAllStudentsPartialData();

	@Query("from Student where firstName=:fName")
	List<Student> findAllStudentsByFirstName(@Param(value = "fName") String firstName);

	@Query("from Student where score>:min and score<:max")
	List<Student> findAllStudentsByGivenScores(@Param(value = "min") int min, @Param(value = "max") int max);

	@Modifying
	@Query("delete from Student where firstName=:fName")
	void deleteStudentsByFirstName(@Param(value = "fName") String fName);

	@Query(value="select * from student", nativeQuery=true)
	List<Student> findAllStudentsNQ();
	
	@Query(value="select * from student where fname=:firstName", nativeQuery=true)
	List<Student> findByFirstNameNQ(@Param(value="firstName") String firstName);
	
}