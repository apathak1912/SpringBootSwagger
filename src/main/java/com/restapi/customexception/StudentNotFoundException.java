package com.restapi.customexception;

public class StudentNotFoundException extends RuntimeException {
	public StudentNotFoundException(String Message){
		super(Message);
	}

}
