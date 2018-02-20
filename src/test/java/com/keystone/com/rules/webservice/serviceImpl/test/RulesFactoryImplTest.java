package com.keystone.com.rules.webservice.serviceImpl.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.keystone.com.rules.webservice.serviceImpl.RulesFactoryImpl;
import com.keystone.common.rules.webservice.service.IRulesInvokerService;
import com.keystone.common.utils.RulesConstants;


@RunWith(MockitoJUnitRunner.class)
public class RulesFactoryImplTest {
	
	@InjectMocks
	RulesFactoryImpl rulesFactoryImpl; 
	
	@Mock
	IRulesInvokerService iRulesInvokerService;
	
	
	
	@Test(expected = Exception.class)
	public void getRulesInvokerTestThrowsException() throws Exception {
		String webserviceType = null;
		IRulesInvokerService actualIRulesInvokerService = rulesFactoryImpl.getRulesInvoker(webserviceType);
		Assert.assertNull(actualIRulesInvokerService);
		
	}
	
	@Test
	public void getRulesInvokerTestRest() throws Exception {
		String webserviceType = RulesConstants.REST;
		IRulesInvokerService actualIRulesInvokerService = rulesFactoryImpl.getRulesInvoker(webserviceType);
		Assert.assertNotNull(actualIRulesInvokerService);
		
	}
	
	@Test
	public void getRulesInvokerTest() throws Exception {
		String webserviceType = RulesConstants.SOAP;
		IRulesInvokerService actualIRulesInvokerService = rulesFactoryImpl.getRulesInvoker(webserviceType);
		Assert.assertNotNull(actualIRulesInvokerService);
		
	}

}
