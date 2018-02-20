package com.keystone.com.rules.webservice.serviceImpl;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.keystone.common.rules.webservice.service.IRulesInvokerService;

/**
 * @author rishkumar
 *
 */
public class RestRulesSerive implements IRulesInvokerService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	
	
	/**
	 * @return ResponseEntity
	 * @param url rest endpoint url
	 * @param httpMethod http method
	 * @param requestEntity request object containing header and body
	 * @param responseType expected response type
	 * @author rishkumar
	 */
	@RequestMapping(method = RequestMethod.GET, produces = { "application/json" })
	public @ResponseBody ResponseEntity<?> getRulesJson(URI url, HttpMethod httpMethod, HttpEntity<?> requestEntity,
			ParameterizedTypeReference<?> responseType) {
		
		ResponseEntity<?> response = new RestTemplate().exchange(url, httpMethod, requestEntity, responseType);
		log.info("going to return RULES ENGINE REST response . Class: "+this.getClass().getName());
		return response;
	}

	

}
