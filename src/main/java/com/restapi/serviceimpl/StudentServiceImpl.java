package com.restapi.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.dao.StudentDao;
import com.restapi.dto.StudentDTO;
import com.restapi.entity.Student;
import com.restapi.service.StudentService;
import com.restapi.util.Mapping;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentDao studentdao;
	
	@Autowired Mapping mapping;

	@Override
	public boolean saveStudent(Student student) {
		return studentdao.persistStudent(student);
		
	}

	@Override
	public StudentDTO getStudentById(Integer id) {
		Student student = studentdao.getStudentById(id);
		if(student !=null) {
			return mapping.mapStudentToStudentDTO(student);
		}else {
			return null;
		}
		
	}

	@Override
	public List<StudentDTO> getAllStudents() {
		List<Student> students = studentdao.getListOfStudents();
		List<StudentDTO> DTOS = new ArrayList<StudentDTO>();
		for(Student student :students) {
			DTOS.add(mapping.mapStudentToStudentDTO(student));	
		}
		return DTOS;
	}

}
