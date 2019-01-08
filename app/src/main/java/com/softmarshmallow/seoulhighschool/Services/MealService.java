package com.softmarshmallow.seoulhighschool.Services;


import android.os.AsyncTask;
import android.util.Log;

import com.softmarshmallow.seoulhighschool.Models.DailyMealContainerModel;
import com.softmarshmallow.seoulhighschool.Models.MealMenuModel;
import com.softmarshmallow.seoulhighschool.Models.MealModel;
import com.softmarshmallow.seoulhighschool.Models.MealType;

import org.hyunjun.school.SchoolException;
import org.hyunjun.school.SchoolMenu;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import io.reactivex.functions.Consumer;

import static com.softmarshmallow.seoulhighschool.Services.ApiController.schoolApi;

public class MealService
{
        
        
        private static final String TAG = "MealService";
        
        public static void GetMonthDailyMeals(final int year, final int month, final Consumer<List<DailyMealContainerModel>> resultCallback, final Consumer<String> errorCallback){
                Log.d(TAG, "GetMonthDailyMeals");
        
                new AsyncTask<Void, Void, List<SchoolMenu>>()
                {
                        @Override
                        protected List<SchoolMenu> doInBackground(Void... voids) {
                                try {
                                        return schoolApi.getMonthlyMenu(year, month);
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
                        protected void onPostExecute(List<SchoolMenu> schoolMenus) {
                                super.onPostExecute(schoolMenus);
                                if (schoolMenus == null){
                                        return;
                                }
                                
                                List<DailyMealContainerModel> monthlyDailyMeals = new ArrayList<DailyMealContainerModel>();
                                int index = 0;
                                for (SchoolMenu schoolMenu : schoolMenus){
        
                                        Date date = new Date(year, month, index+1);
                                        // initialize DailyMealContainerModel
                                        DailyMealContainerModel dailyMealContainerModel = new DailyMealContainerModel();
                                        dailyMealContainerModel.breakfastMeal = ConvertToMealModel(schoolMenu.breakfast, date, MealType.Breakfast);
                                        dailyMealContainerModel.launchMeal = ConvertToMealModel(schoolMenu.lunch, date, MealType.Launch);
                                        dailyMealContainerModel.dinnerMeal = ConvertToMealModel(schoolMenu.dinner,date, MealType.Dinner);
        
                                        monthlyDailyMeals.add(dailyMealContainerModel);
                                        index ++;
                                        
                                }
                                
                                
                                try {
                                        resultCallback.accept(monthlyDailyMeals);
                                }
                                catch (Exception e) {
                                        e.printStackTrace();
                                }
                        }
                }.execute();
        }
        
        
        public static void GetAllMealsOfTheMonth(final int year, final int month, final Consumer<List<MealModel>> resultCallback, final Consumer<String> errorCallback){
                Log.d(TAG, "GetAllMealsOfTheMonth :: year : "+year+" | month : "+ month );
                GetMonthDailyMeals(year, month, new Consumer<List<DailyMealContainerModel>>()
                {
                        @Override
                        public void accept(List<DailyMealContainerModel> dailyMealContainerModels) throws Exception {
                                Log.d(TAG, "dailyMealContainerModels.size() : "+ dailyMealContainerModels.size());
        
                                List<MealModel> allMealDatas = new ArrayList<MealModel>();
                                for(DailyMealContainerModel dailyMealContainerModel : dailyMealContainerModels){
                                        for (Map.Entry<MealType, MealModel> dataSet : dailyMealContainerModel.getAsDictionary().entrySet())
                                        {
                                                MealModel meal = dataSet.getValue();
                                                if (meal != null){
                                                        allMealDatas.add(meal);
                                                }
                                        }
                                }
                                
                                for (MealModel meal : allMealDatas){
                                        Log.d(TAG, "meal is null : " +( meal == null));
                                }
                                
                                resultCallback.accept(allMealDatas);
                                
                                
                        }
                }, new Consumer<String>()
                {
                        @Override
                        public void accept(String s) throws Exception {
                                errorCallback.accept(s);
                        }
                });
        }
        
        private static MealModel ConvertToMealModel( String data,Date date, MealType mealType){
                Log.d(TAG, data);
                if (data.isEmpty() || data == null || data.contains("급식이 없습니다")){
                        Log.d(TAG, "DATA is NULL");
                        return null;
                }
                
                
                MealModel mealModel = new MealModel();
                mealModel.rawData = data;
                mealModel.mealType = mealType;
                mealModel.date = date;
                
                //region set menus
                mealModel.menus = new ArrayList<>();
                for (String s : data.split("\n")){
                        MealMenuModel mealMenuData = new MealMenuModel();
                        mealMenuData.menuName = s;
                        mealModel.menus.add(mealMenuData);
                }
                //endregion
                
                
                
                return mealModel;
        }
        
}
