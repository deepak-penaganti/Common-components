package com.keystone.common.exception;

import java.util.Map;

import javax.validation.ValidationException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.keystone.common.exception.dto.IMessageDTO;
import com.keystone.common.exception.dto.ValidationErrorMessageDTO;
import com.keystone.common.exception.message.ErrorMessage;
import com.keystone.common.exception.types.BusinessValidationException;
import com.keystone.common.exception.types.DataAccessException;
import com.keystone.common.exception.types.ResourceNotFoundException;
import com.keystone.common.utils.ErrorCodes;

import javassist.NotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class CommonExceptionHandlerTest {

	@InjectMocks
	private CommonExceptionHandler handler = new CommonExceptionHandler();

	@Test
	public void testHandleNotFoundException() {
		String exception = "Exception";
		ResponseEntity<ValidationErrorMessageDTO> entity = handler
				.handleNotFoundException(new NotFoundException(exception));
		Assert.assertNotNull(entity);
		ValidationErrorMessageDTO errorMessage = entity.getBody();
		Assert.assertEquals(exception, errorMessage.getMessage());
	}

	@Test
	public void testHandleValidationException() {
		String exception = "Exception";
		ResponseEntity<ValidationErrorMessageDTO> entity = handler
				.handleValidationException(new ValidationException(exception));
		Assert.assertNotNull(entity);
		ValidationErrorMessageDTO errorMessage = entity.getBody();
		Assert.assertEquals(exception, errorMessage.getMessage());
	}

	@Test
	public void testHandleException() {

		String exception = "Exception";
		ResponseEntity<ValidationErrorMessageDTO> entity = handler.handleException(new Exception(exception));
		Assert.assertNotNull(entity);
		ValidationErrorMessageDTO errorMessage = entity.getBody();
		Assert.assertEquals(exception, errorMessage.getMessage());
	}

	@Test
	public void testHandleSecurityException() {

		String exception = "Not authorized to access this resource.";
		ResponseEntity<ErrorMessage> entity = handler
				.handleSecurityException(new com.keystone.common.exception.types.SecurityException(exception, null));
		Assert.assertNotNull(entity);
		ErrorMessage errorMessage = entity.getBody();
		Map<String, IMessageDTO> errorMap = errorMessage.getErrors();
		ValidationErrorMessageDTO message = (ValidationErrorMessageDTO) errorMap.get("error");
		Assert.assertEquals(exception, message.getMessage());
	}

	@Test
	public void testHandleDataAccessException() {

		String exception = "Unable to access the data.";
		ResponseEntity<ErrorMessage> entity = handler.handleDataAccessException(new DataAccessException(exception));
		Assert.assertNotNull(entity);
		ErrorMessage errorMessage = entity.getBody();
		Map<String, IMessageDTO> errorMap = errorMessage.getErrors();
		ValidationErrorMessageDTO message = (ValidationErrorMessageDTO) errorMap.get("error");
		Assert.assertEquals(exception, message.getMessage());
	}

	@Test
	public void testHandleBusinessValidationException() {

		String exception = "Validation failed for data.";
		ResponseEntity<ErrorMessage> entity = handler
				.handleBusinessValidationException(new BusinessValidationException(exception, null));
		Assert.assertNotNull(entity);
		ErrorMessage errorMessage = entity.getBody();
		Map<String, IMessageDTO> errorMap = errorMessage.getErrors();
		ValidationErrorMessageDTO message = (ValidationErrorMessageDTO) errorMap.get("error");
		Assert.assertEquals(exception, message.getMessage());
	}

	@Test
	public void handleResourceNotFoundException() {
		String exception = "Resource Not Found";
		ResponseEntity<ErrorMessage> entity = handler
				.handleResourceNotFoundException(new ResourceNotFoundException(exception, null));
		Assert.assertNotNull(entity);
		ErrorMessage errorMessage = entity.getBody();
		Map<String, IMessageDTO> errorMap = errorMessage.getErrors();
		ValidationErrorMessageDTO message = (ValidationErrorMessageDTO) errorMap.get("error");
		Assert.assertEquals(exception, message.getMessage());
	}

	@Test
	public void testBuildErrorMap() {

		ErrorCodes errorCode = ErrorCodes.APP_TYPE_HEADER_INVALID;
		String msg = "Test";
		ErrorMessage errorMessage = handler.buildErrorMap(errorCode, msg);
		Map<String, IMessageDTO> errorMap = errorMessage.getErrors();
		ValidationErrorMessageDTO message = (ValidationErrorMessageDTO) errorMap.get("error");
		Assert.assertEquals(msg, message.getMessage());
	}

	@Test
	public void testErrorMapBuilder() {
		ErrorCodes errorCode = ErrorCodes.APP_TYPE_HEADER_INVALID;
		String msg = "Test";
		String fieldName = "error";
		ErrorMessage errorMessage = handler.buildErrorMap(errorCode, msg, fieldName);
		Map<String, IMessageDTO> errors = errorMessage.getErrors();
		ValidationErrorMessageDTO errorMessageDTO = (ValidationErrorMessageDTO) errors.get("error");
		Assert.assertEquals(errorMessageDTO.getMessage(), msg);
	}

	@Test
	public void testBuildErrors() {
		ErrorCodes errorCode = ErrorCodes.APP_TYPE_HEADER_INVALID;
		String msg = "Test";
		ValidationErrorMessageDTO dto = (ValidationErrorMessageDTO) handler.buildErrors(errorCode, msg);
		Assert.assertEquals(dto.getMessage(), msg);
	}
}
