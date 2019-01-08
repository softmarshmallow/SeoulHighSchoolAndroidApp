package com.softmarshmallow.seoulhighschool.Views.MealListHelpers.DailyList;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.softmarshmallow.seoulhighschool.Models.DailyMealContainerModel;

import butterknife.ButterKnife;
import io.reactivex.functions.Consumer;

public class DailyMealViewHolder extends RecyclerView.ViewHolder{
        String TAG = "DailyMealViewHolder";
        
        /*
        @BindView(R.id.deliveryDroneNameTextView)
        TextView deliveryDroneNameTextView;
        
        @BindView(R.id.deliveryDroneImageView)
        CircleImageView deliveryDroneImageView;
        */
        private final Context context;
        private DailyMealContainerModel dailyMealContainerModel;
        
        public DailyMealViewHolder(View itemView, final Context context, final Consumer<DailyMealContainerModel> onClickCallback) {
                super(itemView);
                this.context = context;
                
                ButterKnife.bind(this, itemView);
                
                itemView.setOnClickListener(new View.OnClickListener()
                {
                        @Override
                        public void onClick(View view) {
                                Log.d(TAG, "onclick item = " + dailyMealContainerModel.toString());
                                try {
                                        onClickCallback.accept(dailyMealContainerModel);
                                }
                                catch (Exception e) {
                                        e.printStackTrace();
                                }
                        }
                });
        }
        
        public void BindViewithData(DailyMealContainerModel dailyMealContainerModel){
                this.dailyMealContainerModel = dailyMealContainerModel;
        /*
                // set drone image
                if (dailyMealContainerModel.DronePhotoUrl != null && !dailyMealContainerModel.DronePhotoUrl.isEmpty()){
                        Glide.with(context).load(dailyMealContainerModel.DronePhotoUrl).into(deliveryDroneImageView);
                }
                
                // set drone nickname
                deliveryDroneNameTextView.setText(dailyMealContainerModel.DroneNickname);
                */
                //// TODO: 9/23/17
        }
}
