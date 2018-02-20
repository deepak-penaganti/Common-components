package com.keystone.common.exception.types;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SecurityExceptionTest {
	
	private static final String DEFAULT_MESSAGE  = "Default Security Exception Message!";
	
	@Test
	public void testSecurityException() {
		String errorId = "101";
		Exception exception = new Exception("Test");
		SecurityException securityException1 = new SecurityException();
		SecurityException securityException2 = new SecurityException(errorId, exception);
		SecurityException securityException3 = new SecurityException(exception);
		Assert.assertEquals(securityException1.getMessage(), DEFAULT_MESSAGE);
		Assert.assertEquals(securityException2.getMessage(), errorId);
		Assert.assertEquals(securityException3.getCause(), exception);
	}

}
