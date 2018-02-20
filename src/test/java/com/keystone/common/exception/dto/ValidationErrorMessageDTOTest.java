package com.keystone.common.exception.dto;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.keystone.common.exception.message.MessageType;
import com.keystone.common.utils.ErrorCodes;



@RunWith(MockitoJUnitRunner.class)
public class ValidationErrorMessageDTOTest {

	@Test
	public void testValidationErrorMessageDTO() {
		ErrorCodes errorCode = ErrorCodes.GENERIC_EXCEPTION;
		MessageType type = MessageType.ERROR;
		String message = "testMessage";
		ValidationErrorMessageDTO messageDTO = new ValidationErrorMessageDTO(errorCode,type,message);
		messageDTO.setErrorCode(errorCode);
		messageDTO.setMessage(message);
		messageDTO.setType(type);
		Assert.assertEquals(messageDTO.getMessage(), message);
		Assert.assertEquals(messageDTO.getType(), type);
		Assert.assertEquals(messageDTO.getErrorCode(), errorCode);
		Assert.assertNotNull(errorCode.toString());
	}
	
}
