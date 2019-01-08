package com.softmarshmallow.seoulhighschool.Helpers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


public class DateFormatHelper
{
        public static String getDefaultDateFormat(Date date){
        
        
                SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM");
                sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
                return sdf.format(date);
        }
}
