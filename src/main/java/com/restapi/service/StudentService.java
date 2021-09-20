package com.restapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.restapi.dto.StudentDTO;
import com.restapi.entity.Student;
@Service
public interface StudentService {
	
	public boolean saveStudent(Student student);
	
	public StudentDTO getStudentById(Integer id);

	public List<StudentDTO> getAllStudents();

}
