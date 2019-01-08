package com.softmarshmallow.seoulhighschool.Services;

import com.softmarshmallow.seoulhighschool.Helpers.TimeTableDataManager;
import com.softmarshmallow.seoulhighschool.Models.TimeTable.DayType;
import com.softmarshmallow.seoulhighschool.Models.TimeTable.TimeTableItemModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Consumer;

/**
 * Created by uzu on 11/9/17.
 */

public class TimeTableService
{
        
        // *NOTICE* Currently no server connected
        public static void getDayTimeTableRow(DayType dayType, Consumer<List<TimeTableItemModel>> resultCallback, Consumer<String> errorCallback){
                
                List<TimeTableItemModel> timeTableRow = new ArrayList<>();
                for (int i = 0; i <  TimeTableDataManager.MaxIndex; i ++){
                        TimeTableItemModel item = TimeTableDataManager.loadData(dayType, i);
        
                        if (item == null){
                                item = new TimeTableItemModel();
                                item.index = i;
                                item.dayType = dayType;
                                item.content = String.valueOf(i) + " 교시에 시간표가 없습니다."+"\n" + "터치후 설정해주세요.";
                        }
        
        
        
                        timeTableRow.add(item);
                }
        
        
                try {
                        resultCallback.accept(timeTableRow);
                }
                catch (Exception e) {
                        e.printStackTrace();
                }
        
        
        }
        
}
