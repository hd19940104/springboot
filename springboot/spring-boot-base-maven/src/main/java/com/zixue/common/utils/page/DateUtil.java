package com.zixue.common.utils.page;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.apache.commons.lang3.time.DateUtils;

public class DateUtil extends DateUtils {
	public static String defaultDatePattern = "yyyy-MM-dd";
	public static String defaultTimePattern = "yyyy-MM-dd HH:mm:ss";
	public static String defaultTimeRandom = "yyyyMMddHHmmss";
	public static String defaultDateRandom = "yyMMdd";

	private static String[] chars = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p",
			"q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A",
			"B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
			"W", "X", "Y", "Z" };

	private static String[] parsePatterns = { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss",
			"yyyyMMdd" };

	public static final String getToday(String pattern) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);

		return dateFormat.format(new Date());
	}

	public static final String dateToString(Date date, String pattern) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		return dateFormat.format(date);
	}

	public static final Date stringToDate(String date, String pattern) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		try {
			return dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return stringToDate(getToday(pattern), pattern);
	}

	public static final String getRandomName(int lenth) {
		StringBuffer random = new StringBuffer(getToday("yyMMddHH"));
		if (lenth < 5) {
			lenth = 5;
		}
		random.append(generateShortUuid(lenth));

		return random.toString();
	}

	private static String generateShortUuid(int lenth) {
		StringBuffer shortBuffer = new StringBuffer();
		String uuid = UUID.randomUUID().toString().replace("-", "");

		for (int i = 0; i < lenth; i++) {
			String str = uuid.substring(i * 4, i * 4 + 4);
			int x = Integer.parseInt(str, 16);
			shortBuffer.append(chars[(x % 62)].toLowerCase());
		}
		return shortBuffer.toString();
	}

	public static void main(String[] args) {
		getWeekDay();
		getWeek();
	}

	public static String getWeekDay() {
		Date date = new Date();
		SimpleDateFormat strdate = new SimpleDateFormat("E");
		String str = strdate.format(date);
		return str;
	}

	public static String getWeekDay(Date date) {
		SimpleDateFormat strdate = new SimpleDateFormat("E");
		String str = strdate.format(date);
		return str;
	}

	public static String getWeekDay(String date) {
		SimpleDateFormat strdate = new SimpleDateFormat("E");
		String str = strdate.format(stringToDate(date, "yyyy-MM-dd"));
		return str;
	}

	public static int getWeek() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int whichDay1 = cal.get(7);
		return whichDay1;
	}

	public static int getWeek(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int whichDay1 = cal.get(7);
		return whichDay1;
	}

	public static int getWeek(String date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(stringToDate(date, "yyyy-MM-dd"));
		int whichDay1 = cal.get(7);
		return whichDay1;
	}

	public static String getWeekDay(int day) {
		String weekDay = "";
		switch (day) {
		case 1:
			weekDay = "星期日";
			break;
		case 2:
			weekDay = "星期一";

			break;
		case 3:
			weekDay = "星期二";

			break;
		case 4:
			weekDay = "星期三";

			break;
		case 5:
			weekDay = "星期四";

			break;
		case 6:
			weekDay = "星期五";

			break;
		case 7:
			weekDay = "星期六";

			break;
		}

		return weekDay;
	}

	public static Map<String, Date> getWeekDate() {
		Map map = new HashMap();

		return map;
	}

	public static Date parseDate(String str) {
		try {
			return parseDate(str, parsePatterns);
		} catch (ParseException e) {
		}
		return null;
	}
}
