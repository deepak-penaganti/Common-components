package com.keystone.common.utils;

import java.text.ParseException;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class DateUtilsTest {

	@Test
	public void testDateUtils() throws ParseException {
		DateUtils utils = new DateUtils();
		Date date = utils.format("10/01/2015");
		long actual = 1443637800000l;
		Assert.assertEquals(date.getTime(), actual);
	}
}
