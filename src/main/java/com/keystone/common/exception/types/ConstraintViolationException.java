package com.keystone.common.exception.types;

import java.util.Set;

import javax.validation.ConstraintViolation;


public class ConstraintViolationException extends BaseException {

	private static final long serialVersionUID = 1L;
	private Set<ConstraintViolation<IDto>> constraintViolations;
    public ConstraintViolationException(Set<ConstraintViolation<IDto>> violations) {
        super("Constraint Violations found");
        this.constraintViolations = violations;
    }
	public Set<ConstraintViolation<IDto>> getConstraintViolations() {
		return constraintViolations;
	}
    
}
