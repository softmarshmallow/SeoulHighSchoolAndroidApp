package com.softmarshmallow.seoulhighschool.Views.TimeTableEditor;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;
import com.softmarshmallow.seoulhighschool.Helpers.DayTypeLocalizationHelper;
import com.softmarshmallow.seoulhighschool.Models.TimeTable.DayType;
import com.softmarshmallow.seoulhighschool.R;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TimeTableEditorActivity extends AppCompatActivity
{
        
        
        @BindView(R.id.materialViewPager)
        MaterialViewPager mViewPager;
        
        public static Map<Integer, DayType> TabsPositionMapping = new HashMap<Integer, DayType>(){{
                put(0, DayType.Monday);
                put(1, DayType.Tuesday);
                put(2, DayType.Wednesday);
                put(3, DayType.Thursday);
                put(4, DayType.Friday);
                put(5, DayType.Saturday);
                put(6, DayType.Sunday);
        }};
        
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setTheme(R.style.AppTheme_WhiteText);
                setContentView(R.layout.activity_time_table_editor);
                ButterKnife.bind(this);
                setTitle("");
                
                
                
                final Toolbar toolbar = mViewPager.getToolbar();
                if (toolbar != null) {
                        setSupportActionBar(toolbar);
                }
                
                mViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
                        
                        @Override
                        public Fragment getItem(int position) {
        
                                DayType dayType = TabsPositionMapping.get(position);
                                
                                return TimeTable_DayScheduleEditorFragment.newInstance(dayType);
                        }
                        
                        @Override
                        public int getCount() {
                                return TabsPositionMapping.size();
                        }
                        
                        @Override
                        public CharSequence getPageTitle(int position) {
                                DayType dayType = TabsPositionMapping.get(position);
                                return DayTypeLocalizationHelper.getDayTypeLocalizedString("ko", dayType);
                        }
                });
                
                mViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
                        @Override
                        public HeaderDesign getHeaderDesign(int pagePosition) {
                                DayType dayType = TabsPositionMapping.get(pagePosition);
                                
                                switch (dayType) {
                                        case Monday:
                                                return HeaderDesign.fromColorAndUrl(
                                                        Color.GRAY,
                                                        "http://phandroid.s3.amazonaws.com/wp-content/uploads/2014/06/android_google_moutain_google_now_1920x1080_wallpaper_Wallpaper-HD_2560x1600_www.paperhi.com_-640x400.jpg");
                                        case Tuesday:
                                                return HeaderDesign.fromColorAndUrl(
                                                        Color.GRAY,
                                                        "http://www.hdiphonewallpapers.us/phone-wallpapers/540x960-1/540x960-mobile-wallpapers-hd-2218x5ox3.jpg");
                                        case Wednesday:
                                                return HeaderDesign.fromColorAndUrl(
                                                        Color.GRAY,
                                                        "http://www.droid-life.com/wp-content/uploads/2014/10/lollipop-wallpapers10.jpg");
                                        case Thursday:
                                                return HeaderDesign.fromColorAndUrl(
                                                        Color.GRAY,
                                                        "http://www.droid-life.com/wp-content/uploads/2014/10/lollipop-wallpapers10.jpg");
                                        case Friday:
                                                return HeaderDesign.fromColorAndUrl(
                                                        Color.GRAY,
                                                        "http://www.tothemobile.com/wp-content/uploads/2014/07/original.jpg");
                                        case Saturday:
                                                return HeaderDesign.fromColorAndUrl(
                                                        Color.GRAY,
                                                        "http://www.droid-life.com/wp-content/uploads/2014/10/lollipop-wallpapers10.jpg");
                                        case Sunday:
                                                return HeaderDesign.fromColorAndUrl(
                                                        Color.GRAY,
                                                        "http://phandroid.s3.amazonaws.com/wp-content/uploads/2014/06/android_google_moutain_google_now_1920x1080_wallpaper_Wallpaper-HD_2560x1600_www.paperhi.com_-640x400.jpg");
                                        
                                }
                                
                                //execute others actions if needed (ex : modify your header logo)
                                
                                return null;
                        }
                });
                
                mViewPager.getViewPager().setOffscreenPageLimit(mViewPager.getViewPager().getAdapter().getCount());
                mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());
                
                final View logo = findViewById(R.id.logo_white);
                if (logo != null) {
                        logo.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                        mViewPager.notifyHeaderChanged();
                                        Toast.makeText(getApplicationContext(), "Be Proud!!", Toast.LENGTH_SHORT).show();
                                }
                        });
                }
        }
}
