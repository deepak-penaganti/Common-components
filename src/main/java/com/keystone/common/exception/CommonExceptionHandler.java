/**
 * 
 */
package com.keystone.common.exception;


import java.util.HashMap;
import java.util.Map;

import javax.validation.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.keystone.common.exception.dto.IMessageDTO;
import com.keystone.common.exception.dto.ValidationErrorMessageDTO;
import com.keystone.common.exception.message.ErrorMessage;
import com.keystone.common.exception.message.MessageType;
import com.keystone.common.exception.types.BusinessValidationException;
import com.keystone.common.exception.types.DataAccessException;
import com.keystone.common.exception.types.ResourceNotFoundException;
import com.keystone.common.utils.ErrorCodes;

import javassist.NotFoundException;

@ControllerAdvice
public class CommonExceptionHandler {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	/**This method handles custom exception of type 'NotFoundException'
     * @param ex
     * @return A dto containing 'errorCode', 'message' and 'type'
     */
    @ResponseStatus(code=HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ValidationErrorMessageDTO> handleNotFoundException(NotFoundException ex) {
    	ValidationErrorMessageDTO error = (ValidationErrorMessageDTO) buildErrors(ErrorCodes.NOT_FOUND, ex.getMessage());
    	logger.error(""+ error);
        return new ResponseEntity<ValidationErrorMessageDTO>(error, HttpStatus.NOT_FOUND);
    }
    
    /**This method handles exception of type 'ValidationException'
     * @param ex
     * @return A dto containing 'errorCode', 'message' and 'type'
     */
    @ResponseStatus(code=HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ValidationErrorMessageDTO> handleValidationException(ValidationException ex) {
    	ValidationErrorMessageDTO error = (ValidationErrorMessageDTO)buildErrors(ErrorCodes.VALIDATION_ERROR_CODE, ex.getMessage());
    	logger.error(""+ error);
        return new ResponseEntity<ValidationErrorMessageDTO>(error, HttpStatus.BAD_REQUEST);
    }
    
    
    /**This method handles exception of type 'Exception'
     * @param ex 
     * @return A dto containing 'errorCode', 'message' and 'type'
     */
    @ResponseStatus(code=HttpStatus.NOT_FOUND)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ValidationErrorMessageDTO> handleException(Exception ex) {
    	
    	ValidationErrorMessageDTO error = (ValidationErrorMessageDTO) buildErrors(ErrorCodes.GENERIC_EXCEPTION, ex.getMessage());
    	logger.error(""+ error);
    	return new ResponseEntity<ValidationErrorMessageDTO>(error, HttpStatus.NOT_FOUND);
    } 
    
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(com.keystone.common.exception.types.SecurityException.class)
	public ResponseEntity<ErrorMessage> handleSecurityException(com.keystone.common.exception.types.SecurityException ex) {
		ErrorMessage error = buildErrorMap(ErrorCodes.UNAUTHORIZED, "Not authorized to access this resource.");
		return new ResponseEntity<ErrorMessage>(error, HttpStatus.UNAUTHORIZED);
	}
    
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(DataAccessException.class)
	public ResponseEntity<ErrorMessage> handleDataAccessException(DataAccessException ex) {
		ErrorMessage error = buildErrorMap(ErrorCodes.NOT_FOUND, "Unable to access the data.");
		return new ResponseEntity<ErrorMessage>(error, HttpStatus.NOT_FOUND);
	}
    
    @ResponseStatus(code = HttpStatus.PRECONDITION_FAILED)
	@ExceptionHandler(BusinessValidationException.class)
	public ResponseEntity<ErrorMessage> handleBusinessValidationException(BusinessValidationException ex) {
		ErrorMessage error = buildErrorMap(ErrorCodes.PRECONDITION_FAILED, "Validation failed for data.");
		return new ResponseEntity<ErrorMessage>(error, HttpStatus.PRECONDITION_FAILED);
	}
    
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleResourceNotFoundException(ResourceNotFoundException ex) {
		ErrorMessage error = buildErrorMap(ErrorCodes.NOT_FOUND, "Resource Not Found");
		return new ResponseEntity<ErrorMessage>(error, HttpStatus.NOT_FOUND);
	}
    
    protected ErrorMessage buildErrorMap(ErrorCodes errorCode, String msg) {
		return buildErrorMap(errorCode, msg, "error");
	}

	protected ErrorMessage buildErrorMap(ErrorCodes errorCode, String msg, String fieldName) {
		Map<String, IMessageDTO> errors = new HashMap<String, IMessageDTO>();
		IMessageDTO message = new ValidationErrorMessageDTO(errorCode, MessageType.ERROR, msg);
		errors.put(fieldName, message);
		ErrorMessage errorMessage = new ErrorMessage(errors);
		return errorMessage;
	}
    
	/** 
	 * @param errorCode
	 * @param msg
	 * @return A dto containing 'errorCode', 'message' and 'type'
	 */
	IMessageDTO buildErrors(ErrorCodes errorCode, String msg) {
		IMessageDTO message = new ValidationErrorMessageDTO(errorCode, MessageType.EXCEPTION, msg);
		return message;
	}
}
