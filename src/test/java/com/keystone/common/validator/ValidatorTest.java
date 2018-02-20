package com.keystone.common.validator;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ValidationException;
import javax.validation.constraints.NotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.keystone.common.dto.ICommonDTO;

@RunWith(MockitoJUnitRunner.class)
public class ValidatorTest {
	
	class SampleDTO implements ICommonDTO{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		private int id;
		
		@NotNull(message ="Value is must")
		private String value;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
		
	}
	
	Validator validator = new Validator();
	
	@Test
	public void testValidateList() {
		List<SampleDTO> sampleDTOs = new ArrayList<>();
		SampleDTO dto = new SampleDTO();
		dto.setId(10);
		dto.setValue("Test");
		sampleDTOs.add(dto);
		validator.validate(sampleDTOs);
		
	}
	
	@Test(expected = ValidationException.class)
	public void testValidateListException() {
		List<SampleDTO> sampleDTOs = new ArrayList<>();
		SampleDTO dto = new SampleDTO();
		dto.setId(10);
		sampleDTOs.add(dto);
		validator.validate(sampleDTOs);
	}
	
	@Test(expected = ValidationException.class)
	public void testValidateDTO() {
		SampleDTO dto = new SampleDTO();
		dto.setId(10);
		validator.validate(dto);
	}
}
