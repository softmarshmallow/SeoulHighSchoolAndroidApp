package com.softmarshmallow.seoulhighschool.Models;

import java.util.Date;


public class AcademicScheduleModel
{
        public String scheduleContent;
        public Date date;
        
        
        @Override
        public String toString() {
                return "event : " + scheduleContent + "\n"+"at : " + date.toString();
        }
}
