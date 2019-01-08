package com.softmarshmallow.seoulhighschool.Helpers;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.softmarshmallow.seoulhighschool.Models.TimeTable.DayType;
import com.softmarshmallow.seoulhighschool.Models.TimeTable.TimeTableItemModel;
import com.softmarshmallow.seoulhighschool.SeoulHSApplication;

public class TimeTableDataManager
{
        private static Gson gson = new Gson();
        
        public static final int MaxIndex = 10;
        
        static SharedPreferences TimeTableDataPrefs = SeoulHSApplication.getAppContext().getSharedPreferences("TimeTableData",
                Context.MODE_PRIVATE);
        
        static SharedPreferences.Editor TimeTableDataPrefsEditor = TimeTableDataPrefs.edit();
        
        
        public static void clearTimeTableData(){
                TimeTableDataPrefsEditor.clear();
                TimeTableDataPrefsEditor.apply();
        }
        
        
        private static String getKey(DayType dayType, int index){
               return dayType + ":" + index;
        }
        
        
        public static void saveData(TimeTableItemModel timeTableItemData){
                String key = getKey(timeTableItemData.dayType, timeTableItemData.index);
                String json = gson.toJson(timeTableItemData);
                
                TimeTableDataPrefsEditor.putString(key, json);
                TimeTableDataPrefsEditor.apply();
        }
        
        
        public static TimeTableItemModel loadData(DayType dayType, int index){
                String key = getKey(dayType, index);
                String json = TimeTableDataPrefs.getString(key, null);
                return gson.fromJson(json, TimeTableItemModel.class);
        }
}
