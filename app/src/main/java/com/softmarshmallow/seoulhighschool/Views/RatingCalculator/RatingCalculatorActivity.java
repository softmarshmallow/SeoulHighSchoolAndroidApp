package com.softmarshmallow.seoulhighschool.Views.RatingCalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.softmarshmallow.seoulhighschool.Models.RatingCalculation.RatingCalculationItemModel;
import com.softmarshmallow.seoulhighschool.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class RatingCalculatorActivity extends AppCompatActivity
{
        
        @BindView(R.id.recyclerView)
        RecyclerView recyclerView;
        
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_rating_calculator);
                ButterKnife.bind(this);
                
                initData();
                initRecyclerView();
        }
        
        
        List<RatingCalculationItemModel> ratingCalculationItemModelList = new ArrayList<RatingCalculationItemModel>();
        void initData(){
                for (int i = 0; i < 10 ; i++)
                {
                        RatingCalculationItemModel newData =new RatingCalculationItemModel();
                        newData.index = i + 1;
                        ratingCalculationItemModelList.add(newData);
                }
        }
        
        void initRecyclerView() {
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setAdapter(new RatingCalculationAdapter(this,
                        ratingCalculationItemModelList));
        }
        
        
        @OnClick(R.id.calculateButton)
        public void onCalculateButtonClicked() {
                
                float calculationResult = calculateRating();
                
                new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("계산 결과")
                        .setContentText(calculationResult + " 등급")
                        .show();
        }
        
        
        float calculateRating(){
                
                float totalRatingSum = 0;
                float totalAmountSum = 0;
                
                for(RatingCalculationItemModel calculationItem : ratingCalculationItemModelList){
                        float multipliedRatingByAmount = (calculationItem.totalAmount * calculationItem.rate);
                        totalRatingSum += multipliedRatingByAmount;
                        totalAmountSum += calculationItem.totalAmount;
                }
                
                return totalRatingSum / totalAmountSum;
                
        }
        
        
        
        
}
