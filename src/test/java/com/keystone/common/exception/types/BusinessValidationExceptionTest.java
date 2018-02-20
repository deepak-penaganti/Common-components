package com.keystone.common.exception.types;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class BusinessValidationExceptionTest {
	
	private static final String DEFAULT_MESSAGE  = "Default Validation Message!";
	
	@Test
	public void testBusinessValidationException() {
		String astrErrId = "101";
		BusinessValidationException exception = new BusinessValidationException();
		Assert.assertEquals(DEFAULT_MESSAGE, exception.getMessage());
		BusinessValidationException exception1 = new BusinessValidationException(astrErrId, new Exception("Test"));
		Assert.assertEquals(astrErrId, exception1.getMessage());
		Exception test = new Exception("Test");
		BusinessValidationException exception2 = new BusinessValidationException(test);
		Assert.assertEquals(exception2.getCause(), test);
	}

}
