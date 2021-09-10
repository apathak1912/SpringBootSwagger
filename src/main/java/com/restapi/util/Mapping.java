package com.restapi.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.restapi.dto.LibrearyDTO;
import com.restapi.dto.StudentDTO;
import com.restapi.entity.Libreary;
import com.restapi.entity.Student;

@Component
public class Mapping {
	public Libreary mapLibrearyDtoToLibreary(LibrearyDTO dto) {
		return Libreary.builder().bookName((StringUtils.isEmpty(dto.getBookName())) ? null : dto.getBookName())
				.Date_of_Issue(dto.Date_of_Issue).studentId(dto.getStudentId()).build();
	}

	public StudentDTO mapStudentToStudentDTO(Student student) {

		return StudentDTO.builder().address(student.getAddress()).DOB(Utils.convertDateToString(student.getDOB()))
				.firstName(student.getFirstName()).LastName(student.getLastName()).libreary(student.getLibreary())
				.studentId(student.getStudentId()).build();
	}

}
