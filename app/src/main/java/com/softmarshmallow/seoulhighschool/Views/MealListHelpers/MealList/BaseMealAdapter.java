package com.softmarshmallow.seoulhighschool.Views.MealListHelpers.MealList;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softmarshmallow.seoulhighschool.Models.MealModel;
import com.softmarshmallow.seoulhighschool.R;
import com.softmarshmallow.seoulhighschool.Views.MealDetailPage.MealDetailPageActivity;

import java.util.List;

import io.reactivex.functions.Consumer;

public class BaseMealAdapter extends RecyclerView.Adapter
{
        private static final String TAG = "BaseMealAdapter";
        private final Context context;
        private List<MealModel> MealDataList;
        private Consumer<MealModel> onItemClickCallback = new Consumer<MealModel>()
        {
                @Override
                public void accept(MealModel mealModel) throws Exception {
                        Log.d(TAG, "Clicked : " + mealModel.toString());
                        MealDetailPageActivity.StartActivity(context, mealModel);
                }
        };
        
        public BaseMealAdapter(Context context, List<MealModel> MealDataList){
                
                this.context = context;
                this.MealDataList = MealDataList;
        }
        
        public void updateData(List<MealModel> MealDataList){
                this.MealDataList = MealDataList;
                notifyDataSetChanged();
        }
        
        
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                
                
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                View itemView = inflater.inflate(R.layout.card_meal, parent, false);
                return new MealCardViewHolder(itemView,  context, onItemClickCallback);
        }
        
        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                MealCardViewHolder mealViewHolder = (MealCardViewHolder)holder;
        
                MealModel MealData = MealDataList.get(position);
                
                mealViewHolder.BindViewWithData(MealData);
        }
        
        @Override
        public int getItemCount() {
                return  MealDataList != null ? MealDataList.size() : 0;
        }
}