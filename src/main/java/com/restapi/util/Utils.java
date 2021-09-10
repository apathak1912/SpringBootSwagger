package com.restapi.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utils {

	public static String convertDateToString(LocalDate date) {
		LocalDate localDate = date;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
		String formattedString = localDate.format(formatter);
		return formattedString;
	}

}
