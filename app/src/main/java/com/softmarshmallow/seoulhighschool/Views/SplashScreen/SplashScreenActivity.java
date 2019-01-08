package com.softmarshmallow.seoulhighschool.Views.SplashScreen;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.softmarshmallow.seoulhighschool.Helpers.LoginPreferences;
import com.softmarshmallow.seoulhighschool.R;
import com.softmarshmallow.seoulhighschool.Services.ScheduleService;
import com.softmarshmallow.seoulhighschool.Views.MainPage.MainActivity;

import static com.softmarshmallow.seoulhighschool.Helpers.LoginPreferences.APPLICATION_HAS_LOGIN_SERVICE;

public class SplashScreenActivity extends AppCompatActivity
{
        
        
        
        static final String TAG = "SplashScreenActivity";
        final int delayMilliSeconds = 1700;
        
        
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                
                setTheme(R.style.AppTheme_FullScreen);
                setContentView(R.layout.activity_splash_screen);
                
                // todo remove
                Test();
                
                
        }
        
        void Test(){
                // add test code here.
                // DO NOT COMMIT WITH TEST CODE ENABLED.
                ScheduleService.GetMonthlySchedule(2017, 11 ,null, null);
                ScheduleService.GetMonthlySchedule(2017, 12 ,null, null);
                ScheduleService.GetMonthlySchedule(2018, 1 ,null, null);
        }
        
        
        @Override
        protected void onResume() {
                super.onResume();
                StartWaiting();
        }
        
        @Override
        protected void onPause() {
                super.onPause();
                handler.removeCallbacks(r);
        }
        
        
        Handler handler = new Handler();
        Runnable r= new Runnable()
        {
                @Override
                public void run() {
                        MoveToNextActivity();
                }
        };
        void StartWaiting() {
                handler.postDelayed(r , delayMilliSeconds);
                
        }
        
        
        
        void MoveToNextActivity() {
                
                if (APPLICATION_HAS_LOGIN_SERVICE){
                        if (LoginPreferences.getIsLoggedIn()) {
                                MoveToMainAfterAutoLogin();
                        } else {
                               /* Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                                startActivity(intent);
                                finish();*/
                        }
                }else {
                        MoveToMainActivity();
                }
        }
        
        void MoveToMainAfterAutoLogin(){
                /*final SweetAlertDialog autoLoginProgressDialog = new SweetAlertDialog(SplashScreenActivity.this, SweetAlertDialog.PROGRESS_TYPE)
                        .setTitleText("접속중 ..");
                autoLoginProgressDialog.setCancelable(false);
                autoLoginProgressDialog.show();
                
                LoginService.AutoLogin(new OnCompleteListener<AuthResult>()
                {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                                autoLoginProgressDialog.dismiss();
                                
                                if (task.getException() == null){
                                        MoveToMainActivity();
                                }else {
                                        new SweetAlertDialog(SplashScreenActivity.this, SweetAlertDialog.ERROR_TYPE)
                                                .setTitleText("Error while logging in.")
                                                .setContentText(task.getException().getLocalizedMessage())
                                                
                                                .setConfirmText("오프라인으로 계속")
                                                .setConfirmClickListener(
                                                        new SweetAlertDialog.OnSweetClickListener()
                                                        {
                                                                @Override
                                                                public void onClick(SweetAlertDialog sweetAlertDialog) {
                                                                        sweetAlertDialog.dismiss();
                                                                        MoveToMainActivity();
                                                                }
                                                        })
                                                
                                                .setCancelText("재시도")
                                                .setCancelClickListener(
                                                        new SweetAlertDialog.OnSweetClickListener()
                                                        {
                                                                @Override
                                                                public void onClick(SweetAlertDialog sweetAlertDialog) {
                                                                        sweetAlertDialog.dismiss();
                                                                        MoveToMainAfterAutoLogin();
                                                                }
                                                        })
                                                .show();
                                }
                        }
                });*/
        }
        
        void MoveToMainActivity(){
                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
        }
        
}
