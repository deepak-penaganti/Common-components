package com.keystone.common.exception.message;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.keystone.common.exception.dto.IMessageDTO;
import com.keystone.common.exception.dto.ValidationErrorMessageDTO;

@RunWith(MockitoJUnitRunner.class)
public class ErrorMessageTest {

	@Test
	public void testErrorMessage() {
		Map<String, IMessageDTO> errors = new HashMap<>();
		String key = "error";
		ValidationErrorMessageDTO validationError = new ValidationErrorMessageDTO();
		validationError.setMessage("Test");
		errors.put(key, validationError);
		ErrorMessage errorMessage = new ErrorMessage(errors);
		errorMessage.setErrors(errors);
		Assert.assertEquals(errorMessage.getErrors(), errors);
		Assert.assertNotNull(errorMessage.toString());
		ErrorMessage message2  = new ErrorMessage(validationError, key);		
		Map<String, IMessageDTO> errorMap = message2.getErrors();
		Assert.assertEquals(validationError, errorMap.get(key));		
	}
	
}
