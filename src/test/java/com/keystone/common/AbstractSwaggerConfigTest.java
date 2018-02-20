package com.keystone.common;

import static org.mockito.Mockito.mock;

import java.lang.reflect.Field;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.core.env.Environment;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.spring.web.plugins.Docket;

@RunWith(MockitoJUnitRunner.class)
public class AbstractSwaggerConfigTest {

	class SwaggerConfig extends AbstractSwaggerConfig{

		@Override
		public String getBasePackageName() {
			// TODO Auto-generated method stub
			return "testString";
		}
	}
	
	SwaggerConfig config = new SwaggerConfig();
	
	@Test
	public void testSetEnvironment() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Environment environment = mock(Environment.class);
		config.setEnvironment(environment);
		Field fld = config.getClass().getSuperclass().getDeclaredField("propertyResolver");
		fld.setAccessible(true);
		RelaxedPropertyResolver resolver = (RelaxedPropertyResolver) fld.get(config);
		Assert.assertNotNull(resolver);
	}
	
	@Test
	public void testApi() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		RelaxedPropertyResolver resolver = mock(RelaxedPropertyResolver.class);	
		Field fld = config.getClass().getSuperclass().getDeclaredField("propertyResolver");
		fld.setAccessible(true);
		fld.set(config, resolver);			
		Docket docket = config.api();
		Assert.assertNotNull(docket);
	}
	
	@Test
	public void testApiInfo() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field fld = config.getClass().getSuperclass().getDeclaredField("propertyResolver");
		fld.setAccessible(true);
		RelaxedPropertyResolver resolver = mock(RelaxedPropertyResolver.class);
		fld.set(config, resolver);	
		ApiInfo apiInfo = config.apiInfo();
		Assert.assertNotNull(apiInfo);
	}
	
	@Test
	public void testGetBasePackageName() {
		String basePackage = config.getBasePackageName();
		String actual = "testString";
		Assert.assertEquals(basePackage, actual);
	}
}
