package za.co.entelect.jbootcamp.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyUtils {
    public static Date convertStringToDate(String dateString, String format) {
        DateFormat df = new SimpleDateFormat(format);
        Date convertedDate;
        try {
            convertedDate = df.parse(dateString);
            return convertedDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String convertDateToString(Date date, String format) {
        DateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }
}
