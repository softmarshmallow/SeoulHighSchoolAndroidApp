package com.softmarshmallow.seoulhighschool.Views.SchoolIntoduction;

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
import com.softmarshmallow.seoulhighschool.R;
import com.softmarshmallow.seoulhighschool.Views.Development.RecyclerViewFragment;
import com.softmarshmallow.seoulhighschool.Views.SchoolIntoduction.GreetingFromPrincipal.SchoolIntroduction_Greetings_Fragment;
import com.softmarshmallow.seoulhighschool.Views.SchoolIntoduction.SchoolSymbols.SchoolIntroduction_SchoolSymbols_Fragment;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SchoolIntroductionActivity extends AppCompatActivity
{
        
        
        @BindView(R.id.materialViewPager)
        MaterialViewPager mViewPager;
        
        
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setTheme(R.style.AppTheme_WhiteText);
                setContentView(R.layout.activity_school_introduction);
                ButterKnife.bind(this);
                setTitle("");
        
                
                final Toolbar toolbar = mViewPager.getToolbar();
                if (toolbar != null) {
                        setSupportActionBar(toolbar);
                }
        
                mViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
                
                        @Override
                        public Fragment getItem(int position) {
                                
                                IntroductionPageType introductionPageType = IntroductionPageType.MainTabsPositionMapping.get(position);
                                
                                switch (introductionPageType) {
                                        case GreetingFromPrincipal:
                                                return SchoolIntroduction_Greetings_Fragment.newInstance();
                                        case SchoolSymbol:
                                                return SchoolIntroduction_SchoolSymbols_Fragment.newInstance();
                                        //case 0:
                                        //    return RecyclerViewFragment.newInstance();
                                        //case 1:
                                        //    return RecyclerViewFragment.newInstance();
                                        //case 2:
                                        //    return WebViewFragment.newInstance();
                                        default:
                                                return RecyclerViewFragment.newInstance();
                                }
                        }
                
                        @Override
                        public int getCount() {
                                return 2;
                        }
                
                        @Override
                        public CharSequence getPageTitle(int position) {
                                IntroductionPageType introductionPageType = IntroductionPageType.MainTabsPositionMapping.get(position);
        
                                switch (introductionPageType) {
                                        case GreetingFromPrincipal:
                                                return "학교장 인사말";
                                        case SchoolSymbol:
                                                return "학교 상징";
      
                                }
                                return "";
                        }
                });
        
                mViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
                        @Override
                        public HeaderDesign getHeaderDesign(int page) {
                                IntroductionPageType introductionPageType = IntroductionPageType.MainTabsPositionMapping.get(page);
        
                                switch (introductionPageType) {
                                        case GreetingFromPrincipal:
                                                return HeaderDesign.fromColorAndUrl(
                                                        Color.GRAY,
                                                        "http://phandroid.s3.amazonaws.com/wp-content/uploads/2014/06/android_google_moutain_google_now_1920x1080_wallpaper_Wallpaper-HD_2560x1600_www.paperhi.com_-640x400.jpg");
                                        case SchoolSymbol:
                                                return HeaderDesign.fromColorAndUrl(
                                                        Color.GRAY,
                                                        "http://www.hdiphonewallpapers.us/phone-wallpapers/540x960-1/540x960-mobile-wallpapers-hd-2218x5ox3.jpg");
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


enum IntroductionPageType{
        GreetingFromPrincipal(0),
        SchoolHistory(1),
        SchoolSymbol(2),
        EducationalObjectives(3);
        
        
        int value;
        IntroductionPageType(int value) {
                this.value = value;
        }
        
        public int getValue() {
                return value;
        }
        
        
        public static Map<Integer, IntroductionPageType> MainTabsPositionMapping = new HashMap<Integer, IntroductionPageType>(){{
                put(0, IntroductionPageType.GreetingFromPrincipal);
                put(1, IntroductionPageType.SchoolSymbol);
        }};
}