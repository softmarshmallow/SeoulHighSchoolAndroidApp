package com.softmarshmallow.seoulhighschool.Services;

import android.os.AsyncTask;
import android.util.Log;

import com.softmarshmallow.seoulhighschool.Models.AcademicScheduleModel;

import org.hyunjun.school.SchoolException;
import org.hyunjun.school.SchoolSchedule;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.reactivex.functions.Consumer;

import static com.softmarshmallow.seoulhighschool.Services.ApiController.schoolApi;

/**
 * Created by uzu on 10/22/17.
 */

public class ScheduleService
{
        
        private static final String TAG = "ScheduleService";
        
        
        
        public static void GetMonthlySchedule(final int year, final int month, final Consumer<List<AcademicScheduleModel>> resultCallback, final Consumer<String> errorCallback){
        
        
                new AsyncTask<Void, Void, List<SchoolSchedule>>()
                {
                        @Override
                        protected List<SchoolSchedule> doInBackground(Void... voids) {
                                try {
                                        return schoolApi.getMonthlySchedule(year, month);
                                }
                                catch (SchoolException se) {
                                        se.printStackTrace();
                                        try {
                                                errorCallback.accept(se.getLocalizedMessage());
                                        }
                                        catch (Exception e) {
                                                e.printStackTrace();
                                        }
                                        return null;
                                }
                        }
                
                        @Override
                        protected void onPostExecute(List<SchoolSchedule> schoolSchedules) {
                                super.onPostExecute(schoolSchedules);
                                
                                
                                //region rebuild data
                                List<AcademicScheduleModel> remodeledAcademicScheduleModels = new ArrayList<AcademicScheduleModel>();
                                
                                if (schoolSchedules != null){
                                        int index = 0;
                                        for (SchoolSchedule schoolSchedule : schoolSchedules){
                                                if (!schoolSchedule.schedule.isEmpty() && schoolSchedule.schedule != null){
        
                                                        Date date = new Date(year, month, index+1);
                                                        
                                                        AcademicScheduleModel academicScheduleModel = new AcademicScheduleModel();
                                                        academicScheduleModel.scheduleContent = schoolSchedule.schedule;
                                                        academicScheduleModel.date = date;
        
                                                        Log.d(TAG, schoolSchedule.toString());
                                                        remodeledAcademicScheduleModels.add(academicScheduleModel);
        
                                                }
                
                                                index ++;
                                        }
                                }else {
                                        Log.e(TAG, "schoolSchedules : NULL");
                                }
                                
                                
                                
                                if (remodeledAcademicScheduleModels.size() == 0){
                                        AcademicScheduleModel dummyData = new AcademicScheduleModel();
                                        Log.d(TAG, String.valueOf(year));
                                        dummyData.scheduleContent =  year + "년 " + month + "월"+" 에 표시할 정보가 없습니다.";
                                        dummyData.date = new Date();
        
                                        remodeledAcademicScheduleModels.add(dummyData);
                                        
                                }
                                
                                
                                //endregion
                                
                                try {
                                        resultCallback.accept(remodeledAcademicScheduleModels);
                                }
                                catch (Exception e) {
                                        e.printStackTrace();
                                }
                                
                        }
                }.execute();
                
                
        }
        
        
}
