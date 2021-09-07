package com.restapi.reposetry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.restapi.entity.Student;

public interface StudentReposetry extends JpaRepository<Student, Integer>{
	
	@Query(value = "Select * from Student2 where student_id = ?1",nativeQuery = true)
	Student getStudentByID(Integer ID);

}
