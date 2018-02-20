package com.keystone.common.exception.factory;

import com.keystone.common.exception.types.BusinessValidationException;
import com.keystone.common.exception.types.DataAccessException;
import com.keystone.common.exception.types.ResourceNotFoundException;
import com.keystone.common.exception.types.SecurityException;

/**
 * This factory class is used to create the objects of various Exception types
 * as required by the user.
 * 
 * 
 */

public class ExceptionFactory {
	
		
		public static BusinessValidationException createBusinessValidationException(String astrErrId,
				Exception aobjException) {
			return new BusinessValidationException(astrErrId, aobjException);
		}
		
		public static DataAccessException createDataAccessException(String astrErrId,
				Exception aobjException) {
			return new DataAccessException(astrErrId, aobjException);
		}
		
		public static ResourceNotFoundException createResourceNotFoundException(String astrErrId,
				Exception aobjException) {
			return new ResourceNotFoundException(astrErrId, aobjException);
		}
		
		public static SecurityException createSecurityException(String astrErrId,
				Exception aobjException) {
			return new SecurityException(astrErrId, aobjException);
		}
}
