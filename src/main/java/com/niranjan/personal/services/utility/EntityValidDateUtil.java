/**
 * 
 */
package com.niranjan.personal.services.utility;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Niranjan
 *
 */
public class EntityValidDateUtil {
	public static void updateValidDates(Date validFrom, Date validTo) {
		if(validFrom == null) {
			validFrom = new Date();
		}
		if (validTo == null) {
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.DATE, 31);
			calendar.set(Calendar.MONTH, 11);
			calendar.set(Calendar.YEAR, 8888);
			validTo = calendar.getTime();
		}
	}
}
