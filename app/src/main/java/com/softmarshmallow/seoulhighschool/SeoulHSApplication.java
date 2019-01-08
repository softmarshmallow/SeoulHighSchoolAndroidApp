package com.softmarshmallow.seoulhighschool;

import android.app.Application;
import android.content.Context;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;


public class SeoulHSApplication extends Application
{
        
        private static Context context;
        
        @Override
        public void onCreate() {
                super.onCreate();
                // app context
                SeoulHSApplication.context = getApplicationContext();
                
                // CalligraphyConfig
                CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                        .setDefaultFontPath("fonts/AppleSDGothicNeo_Thin.otf")
                        .setFontAttrId(R.attr.fontPath)
                        .build()
                );
                
        }
        
        public static Context getAppContext() {
                return SeoulHSApplication.context;
        }
        
}
