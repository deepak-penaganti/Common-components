package com.keystone.common.exception.types;

/**
 * This Exception class is to handle the security exceptions.
 */
public class SecurityException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private static final String DEFAULT_MESSAGE  = "Default Security Exception Message!";


	public SecurityException() {
		super(DEFAULT_MESSAGE);
	}


	public SecurityException(String errorId, Exception exception) {
		super(errorId, exception);
	}
	


	public SecurityException(Exception exception) {
		super(exception);
	}

}
