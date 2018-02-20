package com.keystone.common.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.ValidatorFactory;

import com.keystone.common.dto.ICommonDTO;

/**
 * @author nnarayanaperumaln
 *
 */
public class Validator{
	private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();	
	javax.validation.Validator validator = factory.getValidator();
	
	public void validate(List<? extends ICommonDTO> accumsEntry) throws ValidationException{
		List<String> errorMessages = new ArrayList<>();
		for(ICommonDTO element : accumsEntry) {
			Set<ConstraintViolation<ICommonDTO>> violations = validator.validate(element);
			for (ConstraintViolation<ICommonDTO> violation : violations) {
				errorMessages.add(violation.getMessage());
			}	
		}
		if(errorMessages.size()>0)
			throw new ValidationException(errorMessages.toString());
	}

	public <T extends ICommonDTO> void validate(T dto) {
		List<String> errorMessages = new ArrayList<>();
		Set<ConstraintViolation<ICommonDTO>> violations = validator.validate(dto);
		for (ConstraintViolation<ICommonDTO> violation : violations) {
			errorMessages.add(violation.getMessage());
		}
		if(errorMessages.size()>0)
			throw new ValidationException(errorMessages.toString());
	}
	
}
