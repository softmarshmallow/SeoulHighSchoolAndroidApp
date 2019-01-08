package com.softmarshmallow.seoulhighschool.Helpers;

import com.softmarshmallow.seoulhighschool.Models.TimeTable.DayType;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by uzu on 11/10/17.
 */

public class DayTypeLocalizationHelper
{
        
        static final Dictionary<String, Map<DayType, String>> LocalizedDayTypeMapDictionary = new Hashtable<String, Map<DayType, String>>(){
                {
                        put("ko", new HashMap<DayType, String>(){{
                                put(DayType.Monday, "월요일");
                                put(DayType.Tuesday, "화요일");
                                put(DayType.Wednesday, "수요일");
                                put(DayType.Thursday, "목요일");
                                put(DayType.Friday, "금요일");
                                put(DayType.Saturday, "토요일");
                                put(DayType.Sunday, "일요일");
                        }});
                }
        };
        
        public static String getDayTypeLocalizedString(String languageCode, DayType dayType){
                try {
                        return LocalizedDayTypeMapDictionary.get(languageCode).get(dayType);
                }catch (Exception ex){
                        return "error :: cannot load localized dayType";
                }
        }
        
        
}
