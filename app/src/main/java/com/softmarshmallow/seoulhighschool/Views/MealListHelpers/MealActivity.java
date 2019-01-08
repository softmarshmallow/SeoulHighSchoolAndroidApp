package com.softmarshmallow.seoulhighschool.Views.MealListHelpers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.softmarshmallow.seoulhighschool.Helpers.CalendarHelper;
import com.softmarshmallow.seoulhighschool.Models.DailyMealContainerModel;
import com.softmarshmallow.seoulhighschool.Models.MealModel;
import com.softmarshmallow.seoulhighschool.R;
import com.softmarshmallow.seoulhighschool.Services.MealService;
import com.softmarshmallow.seoulhighschool.Views.MealListHelpers.DailyList.DailyMealAdapter;
import com.softmarshmallow.seoulhighschool.Views.MealListHelpers.MealList.BaseMealAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;
import io.reactivex.functions.Consumer;

public class MealActivity extends AppCompatActivity
{
        
        
        public static final String TAG = "DroneListActivity";
        
        @BindView(R.id.dailyMealRecyclerView)
        RecyclerView mealRecyclerView;
        
        Calendar calendar = CalendarHelper.getCalendar();
        
        protected Consumer<DailyMealContainerModel> getOnItemClickCallback(){
                return new Consumer<DailyMealContainerModel>()
                {
                        @Override
                        public void accept(DailyMealContainerModel meal) throws Exception {
                                Log.d(TAG, "on delivery drone item clicked | item = " + meal.toString());
                        }
                };
        }
        
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_meal);
                ButterKnife.bind(this);
        
//                InitDailyMealRecyclerView();
        
                InitBasicMealRecyclerView();
        }
        
        
        //region DailyMeal *IMPLEMENT THIS* TODO
        DailyMealAdapter dailyMealAdapter;
        List<DailyMealContainerModel> dailyMealDataList = new ArrayList<>();
        void InitDailyMealRecyclerView(){
                mealRecyclerView.setLayoutManager(new LinearLayoutManager(this));
                dailyMealAdapter = new DailyMealAdapter(this, dailyMealDataList, getOnItemClickCallback());
                mealRecyclerView.setAdapter(dailyMealAdapter);
        
                updateDailyMealData();
        }
        void updateDailyMealData(){
                final SweetAlertDialog loadingProgressDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE)
                        .setTitleText("로딩중..")
                        .setContentText("데이터를 로딩중입니다.");
                loadingProgressDialog.show();
                
                
                
                MealService.GetMonthDailyMeals(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        new Consumer<List<DailyMealContainerModel>>()
                        {
                                @Override
                                public void accept(List<DailyMealContainerModel> datas) throws Exception {
                                        
                                        loadingProgressDialog.dismissWithAnimation();
                                        
                                        dailyMealDataList = datas;
                                        dailyMealAdapter.updateData(dailyMealDataList);
                                }
                        }, new Consumer<String>()
                        {
                                @Override
                                public void accept(String s) throws Exception {
                                        loadingProgressDialog.dismiss();
                                        new SweetAlertDialog(MealActivity.this, SweetAlertDialog.ERROR_TYPE)
                                                .setTitleText("오류")
                                                .setContentText("정보를 받아오는중 오류가 발생하였습니다. message : " + s)
                                                .show();
                                }
                        }
                );
        }
        // endregion
        
        
        //region *THE EASY WAY*
        BaseMealAdapter basicMealAdapter;
        List<MealModel> basicMealDataList = new ArrayList<>();
        void InitBasicMealRecyclerView(){
                mealRecyclerView.setLayoutManager(new LinearLayoutManager(this));
                basicMealAdapter = new BaseMealAdapter(this, basicMealDataList);
                mealRecyclerView.setAdapter(basicMealAdapter);
        
                updateBasicMealData();
        }
        void updateBasicMealData(){
        
                final SweetAlertDialog loadingProgressDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE)
                        .setTitleText("로딩중..")
                        .setContentText("데이터를 로딩중입니다.");
                loadingProgressDialog.show();
        
        
        
                MealService.GetAllMealsOfTheMonth(calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH), new Consumer<List<MealModel>>()
                        {
                                @Override
                                public void accept(List<MealModel> mealModels) throws Exception {
        
                                        loadingProgressDialog.dismissWithAnimation();
        
                                        basicMealDataList = mealModels;
                                        basicMealAdapter.updateData(basicMealDataList);
                                }
                        }, new Consumer<String>()
                        {
                                @Override
                                public void accept(String s) throws Exception {
                                        loadingProgressDialog.dismiss();
                                        new SweetAlertDialog(MealActivity.this, SweetAlertDialog.ERROR_TYPE)
                                                .setTitleText("오류")
                                                .setContentText("정보를 받아오는중 오류가 발생하였습니다. message : " + s)
                                                .show();
                                }
                        });
        
        
        }
        
        
        //endregion
        
        /*
        @OnClick(R.id.backButton)
        void onBackButtonClicked(){
                finish();
        }*/
}
