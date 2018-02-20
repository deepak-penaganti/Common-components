package com.keystone.common.exception.types;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class ResourceNotFoundExceptionTest {
	
	private static final String DEFAULT_MESSAGE  = "Default Resource Not Found Exception Message!";
	
	@Test
	public void testResourceNotFoundException() {
		String errorId = "1001";
		ResourceNotFoundException exception1 = new ResourceNotFoundException();
		ResourceNotFoundException exception2 = new ResourceNotFoundException(errorId, new Exception("test"));
		Exception exception = new Exception("test");
		ResourceNotFoundException exception3 = new ResourceNotFoundException(exception);
		Assert.assertEquals(exception1.getMessage(), DEFAULT_MESSAGE);
		Assert.assertEquals(exception2.getMessage(), errorId);
		Assert.assertEquals(exception3.getCause(), exception);
		
	}

}
