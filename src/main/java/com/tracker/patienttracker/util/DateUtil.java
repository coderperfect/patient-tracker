package com.tracker.patienttracker.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static Date convertToDate(String date) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date convertedDate=null;
		try {
			convertedDate = formatter.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return convertedDate;
	}
}
