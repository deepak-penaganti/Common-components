package com.keystone.common.rules.webservice.service;

import java.net.URI;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;



public interface IRulesInvokerService {

	public @ResponseBody ResponseEntity<?> getRulesJson(URI url, HttpMethod method, HttpEntity<?> requestEntity,
			ParameterizedTypeReference<?> responseType);
	

}
