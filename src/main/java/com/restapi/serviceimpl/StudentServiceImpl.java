package com.restapi.serviceimpl;

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

}
