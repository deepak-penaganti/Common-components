package com.keystone.common.exception.factory;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.keystone.common.exception.types.BusinessValidationException;
import com.keystone.common.exception.types.DataAccessException;
import com.keystone.common.exception.types.ResourceNotFoundException;
import com.keystone.common.exception.types.SecurityException;


@RunWith(MockitoJUnitRunner.class)
public class ExceptionFactoryTest {

	@Test
	public void testExceptionFactory() {
		ExceptionFactory factory = new ExceptionFactory();
		String astrErrId = "100";
		BusinessValidationException businessValidationException = factory.createBusinessValidationException(astrErrId, new Exception("test"));
		Assert.assertEquals(astrErrId, businessValidationException.getMessage());
		DataAccessException dataAccessException = factory.createDataAccessException(astrErrId, new Exception("test"));
		Assert.assertEquals(astrErrId, dataAccessException.getMessage());
		ResourceNotFoundException resourceNotFoundException = factory.createResourceNotFoundException(astrErrId, new Exception("test"));
		Assert.assertEquals(astrErrId, resourceNotFoundException.getMessage());
		SecurityException securityException = factory.createSecurityException(astrErrId, new Exception("Test"));
		Assert.assertEquals(astrErrId, securityException.getMessage());
	}
}
