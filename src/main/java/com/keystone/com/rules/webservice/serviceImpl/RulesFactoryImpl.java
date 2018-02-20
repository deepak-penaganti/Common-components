package com.keystone.com.rules.webservice.serviceImpl;

import com.keystone.common.rules.webservice.service.IRulesFactory;
import com.keystone.common.rules.webservice.service.IRulesInvokerService;
import com.keystone.common.utils.RulesConstants;


public class RulesFactoryImpl extends IRulesFactory{

	
	IRulesInvokerService rulesInvoker ;

	/**
	 * This is the invoker service which returns SOAP/REST object(based on the factory design pattern) to the client 
	 * @return {@link IRulesInvokerService} the reference of interface IRulesInvokerService
	 * @param webserviceType. Type of request
	 * @throws Exception thrown if  WebserviceType is null
	 */
	@Override
	public  IRulesInvokerService getRulesInvoker(String webserviceType) throws Exception {
		
		if(webserviceType == null ) {
			throw new Exception("WebserviceType is required");
		}
		
		if(webserviceType.equalsIgnoreCase(RulesConstants.REST)) {
			rulesInvoker = new RestRulesSerive();
		}
		
		
		return rulesInvoker;
	}
	 

}
