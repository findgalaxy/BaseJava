package com.lm.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	public static String toDate(Date date) {
		DateFormat dFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 return dFormat.format(date);
	}
}
