package com.softmarshmallow.seoulhighschool.Helpers;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created by uzu on 11/11/17.
 */

public class CalendarHelper
{
        private static Calendar calendar = Calendar.getInstance();
        
        public static Calendar getCalendar(){
                calendar.setTimeZone(TimeZone.getTimeZone("GMT"));
                return calendar;
        }
}
