/**
 * 
 */
package com.keystone.common.exception.message;

import java.util.Map;

import com.google.common.collect.Maps;
import com.keystone.common.exception.dto.IMessageDTO;

/**
 * @author nnarayanaperumaln
 *
 */
public class ErrorMessage {
	 private Map<String,IMessageDTO> errors = Maps.newHashMap();;
	    
	    public ErrorMessage() {
		}
	    public ErrorMessage( Map<String, IMessageDTO> errors) {
			this.errors = errors;
		}
	    
	    public ErrorMessage(IMessageDTO error, String errorProperty) {
			addError(error, errorProperty);
		}
		private void addError(IMessageDTO error, String errorProperty) {
			this.errors.put(errorProperty, error);
		}
	    
		@Override
		public String toString() {
			return "errors=" + errors;
		}
		public Map<String, IMessageDTO> getErrors() {
			return errors;
		}
		public void setErrors(Map<String, IMessageDTO> errors) {
			this.errors = errors;
		}
}
