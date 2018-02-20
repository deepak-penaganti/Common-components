package com.keystone.common.exception.types;

/**
 * This Exception class is to handle the validation exceptions.
 */
public class BusinessValidationException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private static final String DEFAULT_MESSAGE  = "Default Validation Message!";

	public BusinessValidationException() {
		super(DEFAULT_MESSAGE);
	}


	public BusinessValidationException(String astrErrId, Exception aobjException) {
		super(astrErrId, aobjException);
	}
	

	BusinessValidationException(Exception aobjException) {
		super(aobjException);
	}
}
