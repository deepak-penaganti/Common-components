package com.keystone.common.exception.types;

/**
 * This Exception class is to handle the resource not found exceptions.
 */
public class ResourceNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private static final String DEFAULT_MESSAGE  = "Default Resource Not Found Exception Message!";

	public ResourceNotFoundException() {
		super(DEFAULT_MESSAGE);
	}

	
	public ResourceNotFoundException(String errorId, Exception exception) {
		super(errorId, exception);
	}
	

	public ResourceNotFoundException(Exception exception) {
		super(exception);
	}

}

