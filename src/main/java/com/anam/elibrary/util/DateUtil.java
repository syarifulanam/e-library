package com.anam.elibrary.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static Date convertStringToDate(String format, String value) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            return dateFormat.parse(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
