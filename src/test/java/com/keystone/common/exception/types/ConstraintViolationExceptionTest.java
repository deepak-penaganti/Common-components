package com.keystone.common.exception.types;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ConstraintViolationExceptionTest {
	
	Set<ConstraintViolation<IDto>> constraintViolations = new HashSet<>();
	
	@Test
	public void testConstraintViolationException() {
		
		ConstraintViolationException exception = new ConstraintViolationException(constraintViolations);
		Assert.assertEquals(exception.getConstraintViolations(), constraintViolations);
		
	}

}
