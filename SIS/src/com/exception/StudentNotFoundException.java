package com.exception;

public class StudentNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8029737671881013394L;
	private String message;

	public StudentNotFoundException(String message) {
		
		this.message = message;
	}
	
	public String getMessage() {
    	return message;
    }
}
