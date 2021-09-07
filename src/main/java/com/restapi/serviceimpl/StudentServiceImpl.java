package com.restapi.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.dao.StudentDao;
import com.restapi.entity.Student;
import com.restapi.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentDao studentdao;

	@Override
	public boolean saveStudent(Student student) {
		return studentdao.persistStudent(student);
		
	}

	@Override
	public Student getStudentById(Integer id) {
		return studentdao.getStudentById(id);
	}

}
