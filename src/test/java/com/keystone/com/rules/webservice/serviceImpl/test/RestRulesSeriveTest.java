package com.keystone.com.rules.webservice.serviceImpl.test;

import static org.mockito.Mockito.when;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.keystone.com.rules.webservice.serviceImpl.RestRulesSerive;



/**
 * @author vamehta
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class RestRulesSeriveTest {

	@InjectMocks
	  private RestRulesSerive restRulesSerive;

	  @Mock
	  private RestTemplate template;
	  
	  @Mock
	  ResponseEntity<?> response;

	@Test
	public void getRulesJsonTest() throws URISyntaxException {
		String uribase = "https://www.hcsc.com/";
        // Constructor to create a new URI
        // by parsing the string
        URI uriBase = new URI(uribase);
        when(template.exchange(Mockito.any(), Mockito.<HttpMethod>any(),
				Mockito.<HttpEntity<?>>any(), Mockito.<Class<Object>>any())).thenReturn((ResponseEntity<Object>) response);
        ResponseEntity<?> actualResponse = restRulesSerive.getRulesJson(uriBase,HttpMethod.GET,
				 new HttpEntity<>(""), new ParameterizedTypeReference<Object>() {
				});
        Assert.assertNotNull(actualResponse);

	}

}
