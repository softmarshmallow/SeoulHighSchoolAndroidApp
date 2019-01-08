package com.softmarshmallow.seoulhighschool.Views.MainPage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.mxn.soul.flowingdrawer_core.FlowingDrawer;
import com.mxn.soul.flowingdrawer_core.FlowingMenuLayout;
import com.softmarshmallow.seoulhighschool.Helpers.CalendarHelper;
import com.softmarshmallow.seoulhighschool.Helpers.SchoolInfoConfig;
import com.softmarshmallow.seoulhighschool.Models.AcademicScheduleModel;
import com.softmarshmallow.seoulhighschool.Models.DailyMealContainerModel;
import com.softmarshmallow.seoulhighschool.Models.MealMenuModel;
import com.softmarshmallow.seoulhighschool.Models.MealModel;
import com.softmarshmallow.seoulhighschool.Models.TimeTable.DayType;
import com.softmarshmallow.seoulhighschool.Models.TimeTable.TimeTableItemModel;
import com.softmarshmallow.seoulhighschool.R;
import com.softmarshmallow.seoulhighschool.Services.MealService;
import com.softmarshmallow.seoulhighschool.Services.ScheduleService;
import com.softmarshmallow.seoulhighschool.Services.TimeTableService;
import com.softmarshmallow.seoulhighschool.Views.MealListHelpers.MealList.BaseMealAdapter;
import com.softmarshmallow.seoulhighschool.Views.ScheduleListHelpers.BaseScheduleAdapter;
import com.softmarshmallow.seoulhighschool.Views.TimeTableEditor.TimeTableListAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.pedant.SweetAlert.SweetAlertDialog;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity
{
        
        
        private static final String TAG = "MainActivity";
        
        
        @BindView(R.id.toolbar)
        Toolbar toolbar;
        
        
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                ButterKnife.bind(this);
        
                InitNavDrawer();
                
                InitPromotionSlider();
        
                initUpcomingMealRecyclerView();
        
                initUpcomingScheduleRecyclerView();
        
                initTimeTableRecyclerView();
                
                TEST();
        }
        
        
        
        //region InitNavDrawer
        
        @BindView(R.id.menulayout)
        FlowingMenuLayout menulayout;
        
        
        @OnClick(R.id.showSideNavigationButton)
        void OnShowSideNavigationButtonClick(){
                drawerlayout.openMenu(true);
        }
        
        
        @BindView(R.id.container_menu)
        ViewGroup containerView;
        
        @BindView(R.id.drawerlayout)
        FlowingDrawer drawerlayout;
        void InitNavDrawer(){
                View drawerView = MainNavigationDrawer.GetNavigationDrawerView(this, toolbar);
                containerView.addView(drawerView, 0, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
        }
        //endregion
        
        
        
        //region PromotionSlider
        @BindView(R.id.promotionImageSlider)
        SliderLayout promotionImageSlider;
        
        void InitPromotionSlider() {
                
                //region
                DefaultSliderView festivalPromotionSlide = addImageToSlider(R.drawable.promotion1);
   /*             festivalPromotionSlide.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener()
                {
                        @Override
                        public void onSliderClick(BaseSliderView slider) {
                                //region Open facebook page
                                String url = SchoolInfoConfig.MAIN_FACEBOOK_URL;
                                Intent i = new Intent(Intent.ACTION_VIEW);
                                i.setData(Uri.parse(url));
                                startActivity(i);
                                //endregion
                        }
                });*/
                //endregion
                
        
                //region
                DefaultSliderView broadcastPromotionSlide = addImageToSlider(R.drawable.promotion2);
                broadcastPromotionSlide.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener()
                {
                        @Override
                        public void onSliderClick(BaseSliderView slider) {
                                //region Open facebook page
                                String url = SchoolInfoConfig.FACEBOOK_BROADCAST_PAGE_URL;
                                Intent i = new Intent(Intent.ACTION_VIEW);
                                i.setData(Uri.parse(url));
                                startActivity(i);
                                //endregion
                        }
                });
                //endregion
        
        
                //region
        
                DefaultSliderView facebook1_PromotionSlide = addImageToSlider(R.drawable.promotion3_1);
                facebook1_PromotionSlide.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener()
                {
                        @Override
                        public void onSliderClick(BaseSliderView slider) {
                                //region Open facebook page
                                String url = SchoolInfoConfig.MAIN_FACEBOOK_URL;
                                Intent i = new Intent(Intent.ACTION_VIEW);
                                i.setData(Uri.parse(url));
                                startActivity(i);
                                //endregion
                        }
                });
                //endregion
        
        
                //region
                DefaultSliderView facebook2_PromotionSlide = addImageToSlider(R.drawable.promotion3_2);
                facebook2_PromotionSlide.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener()
                {
                        @Override
                        public void onSliderClick(BaseSliderView slider) {
                                //region Open facebook page
                                String url = SchoolInfoConfig.MAIN_FACEBOOK_URL;
                                Intent i = new Intent(Intent.ACTION_VIEW);
                                i.setData(Uri.parse(url));
                                startActivity(i);
                                //endregion
                        }
                });
                //endregion
        
        }
        
        DefaultSliderView addImageToSlider(int drawableRes){
                DefaultSliderView newSliderImageView = (DefaultSliderView) new DefaultSliderView(
                        this).image(drawableRes);
                newSliderImageView.setScaleType(BaseSliderView.ScaleType.Fit);
                
                promotionImageSlider.addSlider(newSliderImageView);
                return newSliderImageView;
        }
        //endregion
        
        
        
        
        
        Calendar calendar = CalendarHelper.getCalendar();
        //region upcomingMealRecyclerView
        
        @BindView(R.id.mealRecyclerview)
        RecyclerView mealRecyclerview;
        BaseMealAdapter upcomingMealAdapter;
        RecyclerView.LayoutManager mealRecyclerviewRecyclerViewLayoutManager;
        List<MealModel> mealDatas = new ArrayList<>();
        
        void initUpcomingMealRecyclerView() {
                
                mealRecyclerviewRecyclerViewLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
                mealRecyclerview.setLayoutManager(mealRecyclerviewRecyclerViewLayoutManager);
                upcomingMealAdapter = new BaseMealAdapter(this,mealDatas);
                mealRecyclerview.setAdapter(upcomingMealAdapter);
        
        
                updateUpcomingMeals();
        }
        
        void updateUpcomingMeals(){
                Log.d(TAG, "updateUpcomingMeals");
                
                MealService.GetAllMealsOfTheMonth(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        new Consumer<List<MealModel>>()
                        {
                                @Override
                                public void accept(List<MealModel> mealModels) throws Exception {
                                        mealDatas = mealModels;
                                        Log.d(TAG,  "mealdata size" + mealDatas.size());
                                        upcomingMealAdapter.updateData(mealDatas);
                                }
                        }, new Consumer<String>()
                        {
                                @Override
                                public void accept(String s) throws Exception {
                                        new SweetAlertDialog(MainActivity.this, SweetAlertDialog.ERROR_TYPE)
                                                .setTitleText("Error while getting Meal datas")
                                                .setContentText(s)
                                                .setConfirmText("Retry")
                                                .setCancelClickListener(
                                                        new SweetAlertDialog.OnSweetClickListener()
                                                        {
                                                                @Override
                                                                public void onClick(SweetAlertDialog sweetAlertDialog) {
                                                                        sweetAlertDialog.dismissWithAnimation();
                                                                        updateUpcomingMeals();
                                                                }
                                                        })
                                                .show();
                                }
                        });
                        
                
                
        }
        //endregion
        
        
        
        
        
        
        
        //region upcomingScheduleRecyclerView
        
        @BindView(R.id.schoolScheduleRecyclerview)
        RecyclerView schoolScheduleRecyclerview;
        BaseScheduleAdapter upcomingScheduleAdapter;
        RecyclerView.LayoutManager upcomingScheduleRecyclerViewLayoutManager;
        List<AcademicScheduleModel> scheduleDatas = new ArrayList<>();
        
        void initUpcomingScheduleRecyclerView() {
        
                upcomingScheduleRecyclerViewLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
                schoolScheduleRecyclerview.setLayoutManager(upcomingScheduleRecyclerViewLayoutManager);
                upcomingScheduleAdapter = new BaseScheduleAdapter(this, scheduleDatas);
                schoolScheduleRecyclerview.setAdapter(upcomingScheduleAdapter);
                
                updateUpcomingSchedules();
        }
        
        void updateUpcomingSchedules(){
                Log.d(TAG, "updateUpcomingSchedules");
        
        
                ScheduleService.GetMonthlySchedule(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        new Consumer<List<AcademicScheduleModel>>()
                        {
                                @Override
                                public void accept(List<AcademicScheduleModel> academicScheduleModels) throws Exception {
                                        scheduleDatas = academicScheduleModels;
                                        Log.d(TAG, "SIZE = " + scheduleDatas.size());
                                        upcomingScheduleAdapter.updateData(scheduleDatas);
                                }
                        }, new Consumer<String>()
                        {
                                @Override
                                public void accept(String s) throws Exception {
                                        new SweetAlertDialog(MainActivity.this, SweetAlertDialog.ERROR_TYPE)
                                                .setTitleText("Error while getting Store datas")
                                                .setContentText(s)
                                                .setConfirmText("Retry")
                                                .setCancelClickListener(
                                                        new SweetAlertDialog.OnSweetClickListener()
                                                        {
                                                                @Override
                                                                public void onClick(SweetAlertDialog sweetAlertDialog) {
                                                                        sweetAlertDialog.dismissWithAnimation();
                                                                        updateUpcomingMeals();
                                                                }
                                                        })
                                                .show();
                                }
                        });
                
        }
        //endregion
        
        
        
        
        
        
        //region today's time table
        
        
        @BindView(R.id.timeTableRecyclerView)
        RecyclerView timeTableRecyclerView;
        TimeTableListAdapter timeTableRecyclerViewAdapter;
        RecyclerView.LayoutManager timeTableRecyclerViewLayoutManager;
        List<TimeTableItemModel> timeTableItemDataList = new ArrayList<>();
        
        void initTimeTableRecyclerView() {
                
                timeTableRecyclerViewLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
                timeTableRecyclerView.setLayoutManager(
                        timeTableRecyclerViewLayoutManager);
                timeTableRecyclerViewAdapter = new TimeTableListAdapter(this, timeTableItemDataList);
                timeTableRecyclerView.setAdapter(timeTableRecyclerViewAdapter);
                
                updateTimeTableItemData();
        }
        
        void updateTimeTableItemData(){
                Log.d(TAG, "updateTimeTableItemData");
                Calendar cal = Calendar.getInstance();
                cal.setTimeZone(TimeZone.getTimeZone("GMT"));
                int dayTypeInInt = cal.get(Calendar.DAY_OF_WEEK);
                
                TimeTableService.getDayTimeTableRow(DayType.getEnum(dayTypeInInt),
                        new Consumer<List<TimeTableItemModel>>()
                        {
                                @Override
                                public void accept(List<TimeTableItemModel> timeTableItemModels) throws Exception {
                                        timeTableItemDataList = timeTableItemModels;
                                        Log.d(TAG, "SIZE = " + timeTableItemDataList.size());
                                        timeTableRecyclerViewAdapter.updateData(
                                                timeTableItemDataList);
                                        
                                }
                        }, new Consumer<String>()
                        {
                                @Override
                                public void accept(String s) throws Exception {
                                        
                                }
                        }
                );
        }
        
        
        //endregion
        
        
        
        
        //region
        
        
        @Override
        public void onBackPressed() {
                AskIfQuitApp();
        }
        
        void AskIfQuitApp(){
                new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                        .setTitleText("같이 있어요~ 네?")
                        .setContentText("정말 가실거에요?")
                        .setCancelText("좀만더 이따 갈까?")
                        .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sDialog) {
                                        sDialog.cancel();
                                }
                        })
                        
                        .setConfirmText("담에봐 ㅠ")
                        .setConfirmClickListener (new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sDialog) {
                                        sDialog.dismissWithAnimation();
                                        finish();
                                }
                        }).show();
        }
        
        //endregion
        
        
        
        
        
        
        
        
        
        void TEST() {
                
        }
        
}
