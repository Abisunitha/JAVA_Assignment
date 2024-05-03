package com.exception;

public class CourseNotFoundException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1179111135914978593L;
	private String message;

	public CourseNotFoundException(String message) {
		
		this.message = message;
	}
	
	public String getMessage() {
    	return message;
    }
}
