package com.restapi.customexception;

public class NotAbleToDelete extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public NotAbleToDelete(String message) {
		super(message);
	}

}
