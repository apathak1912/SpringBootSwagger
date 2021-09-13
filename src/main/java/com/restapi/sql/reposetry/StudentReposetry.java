package com.restapi.sql.reposetry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.restapi.entity.Student;

public interface StudentReposetry extends JpaRepository<Student, Integer>{
	
	@Query(value = "Select * from Student2 where student_id = :ID",nativeQuery = true)
	Student getStudentByID(@Param("ID")Integer ID);

}
