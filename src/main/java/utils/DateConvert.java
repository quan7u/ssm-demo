package utils;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConvert {

	public static Date convert2Date(String bir) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		ParsePosition pos = new ParsePosition(0);
		Date date = sdf.parse(bir);
		return date;
	}
	
	public static String convert2d(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }
	
	public static String convert2s(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        return sdf.format(date);
    }
	
	public static String convert2json(Long l){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
		Date date = new Date(l);
		return sdf.format(date);
	}
}
