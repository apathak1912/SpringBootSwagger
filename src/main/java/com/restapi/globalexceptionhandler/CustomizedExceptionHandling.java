package com.restapi.globalexceptionhandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.restapi.customexception.NotAbleToDelete;
import com.restapi.customexception.StudentNotFoundException;
import com.restapi.responses.ExceptionResponse;

@ControllerAdvice
public class CustomizedExceptionHandling extends ResponseEntityExceptionHandler {

	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<Object> handleStudentNotFoundException(StudentNotFoundException se,WebRequest wr){
		ExceptionResponse response = ExceptionResponse.builder().message("NOT FOUND "+se.getMessage()).dateTime(LocalDateTime.now()).build();
		ResponseEntity<Object> entity = new ResponseEntity<Object>(response,HttpStatus.NOT_FOUND);
		return entity;
	}
	
	@ExceptionHandler(NotAbleToDelete.class)
	public ResponseEntity<Object> notAbletoDelete(NotAbleToDelete na,WebRequest wr){
		ExceptionResponse response = ExceptionResponse.builder().message("DATA HAS NOT BEEN DELETED FOR "+na.getMessage())
				.dateTime(LocalDateTime.now()).build();
		return new ResponseEntity<>(response,HttpStatus.EXPECTATION_FAILED);
	}
}
