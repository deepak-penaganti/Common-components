package com.keystone.common.rules.webservice.service;

public abstract class IRulesFactory {
	
	public  abstract IRulesInvokerService getRulesInvoker(String webserviceType) throws Exception;

}
