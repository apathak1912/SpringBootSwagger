package com.restapi.service;

import org.springframework.stereotype.Service;

import com.restapi.entity.Student;
@Service
public interface StudentService {
	
	public boolean saveStudent(Student student);
	
	public Student getStudentById(Integer id);

}
