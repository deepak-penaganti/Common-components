package com.keystone.common.exception.types;

import static org.mockito.Mockito.mock;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DataAccessExceptionTest {
	
	@Test
	public void testDataAccessException() {
		String message = "Test";		
		DataAccessException accessException1 = new DataAccessException(message, new SQLException("test"));
		DataAccessException accessException2 = new DataAccessException(message);
		DataAccessException accessException3 = new DataAccessException(new IOException("test"));
		Exception exception = new Exception(message);
		DataAccessException accessException4 = new DataAccessException(exception);
		accessException1.printStackTrace();
		PrintStream apsObj = mock(PrintStream.class);
		PrintWriter apwObj = mock(PrintWriter.class);
		accessException1.printStackTrace(apsObj);
		accessException2.printStackTrace(apwObj);
		Assert.assertEquals(accessException1.getErrorCause(), DataAccessException.DB_EXCEPTION);
		Assert.assertEquals(accessException3.getErrorCause(), DataAccessException.MESSAGE_BROKER_CALL_EXCEPTION);
		Assert.assertEquals(accessException4.getErrorCause(), exception.toString());
		Assert.assertNull(accessException2.getErrorCause());
	}

}
