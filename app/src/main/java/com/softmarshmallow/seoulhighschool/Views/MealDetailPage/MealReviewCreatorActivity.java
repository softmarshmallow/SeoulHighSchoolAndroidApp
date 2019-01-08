package com.softmarshmallow.seoulhighschool.Views.MealDetailPage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.RatingBar;


import com.softmarshmallow.seoulhighschool.R;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.pedant.SweetAlert.SweetAlertDialog;
import io.reactivex.functions.Consumer;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

// import java.util.function.Consumer;

public class MealReviewCreatorActivity extends AppCompatActivity
{

        private static final String TAG = MealReviewCreatorActivity.class.getName();
        @BindView(R.id.ReviewRatingbar)
        RatingBar reviewRatingBar;

        @BindView(R.id.ReviewContentEditText)
        EditText reviewContentEditText;



        private static String baseStoreId;
        public static void StartActivity(String id, Context context){
//                StoreReviewCreaterActivity.baseStoreId = id;
                Intent intent = new Intent(context, MealReviewCreatorActivity.class);
                context.startActivity(intent);
        }


        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
//                setTheme(R.style.AppTheme_WithActionBar);
                setContentView(R.layout.activity_meal_review_creater);

                ButterKnife.bind(this);
        }


        @OnClick(R.id.UploadReviewButton)
        void OnUploadReviewButtonClick() {
                Log.d(TAG, "OnUploadReviewButtonClick");


                final SweetAlertDialog uploadingDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE)
                        .setTitleText("Uploading");
                uploadingDialog.show();
        
                uploadingDialog.dismissWithAnimation();
        
        }


        @Override
        protected void attachBaseContext(Context newBase) {
                super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
        }

}
