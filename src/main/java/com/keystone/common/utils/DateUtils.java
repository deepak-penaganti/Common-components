/**
 * 
 */
package com.keystone.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author nnarayanaperumaln
 * Utility for all Date functionality
 */
public class DateUtils {

	/**
	 * Default DATE format
	 */
	private static SimpleDateFormat FORMAT = new SimpleDateFormat("MM/dd/yyyy");
	
	/**
	 * Converts the String to Date in the declared format
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date format(String date) throws ParseException {
		//converts the String to Date and in the FORMAT declared
		return FORMAT.parse(date);
	}
}
