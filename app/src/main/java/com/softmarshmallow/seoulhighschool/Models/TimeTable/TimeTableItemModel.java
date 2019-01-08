package com.softmarshmallow.seoulhighschool.Models.TimeTable;


import com.softmarshmallow.seoulhighschool.Helpers.TimeTableDataManager;

public class TimeTableItemModel
{
        //        public DayType dayType;
        public DayType dayType;
        public int index;
        public String content;
        
        public void save(){
                TimeTableDataManager.saveData(this);
        }
        
        
        @Override
        public String toString() {
                return "dayType :: " +dayType + " || " +  "index :: " + index + " || " +  "content :: "+ content;
        }
}
