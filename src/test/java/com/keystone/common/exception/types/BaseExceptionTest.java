package com.keystone.common.exception.types;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BaseExceptionTest {

	@Test
	public void testBaseException() {
		
		BaseException exception = new BaseException("Test");
		Assert.assertNotNull(exception.getMessage());
		
	}
	
}
