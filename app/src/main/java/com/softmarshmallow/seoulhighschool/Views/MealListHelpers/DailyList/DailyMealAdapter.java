package com.softmarshmallow.seoulhighschool.Views.MealListHelpers.DailyList;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softmarshmallow.seoulhighschool.Models.DailyMealContainerModel;
import com.softmarshmallow.seoulhighschool.R;

import java.util.List;

import io.reactivex.functions.Consumer;

public class DailyMealAdapter extends RecyclerView.Adapter
{
        
        
        private final Context context;
        private List<DailyMealContainerModel> dailyMealDataList;
        private Consumer onItemClickCallback;
        
        public DailyMealAdapter(Context context, List<DailyMealContainerModel> dailyMealDataList, Consumer onItemClickCallback){
                
                this.context = context;
                this.dailyMealDataList = dailyMealDataList;
                this.onItemClickCallback = onItemClickCallback;
        }
        
        public void updateData(List<DailyMealContainerModel> dailyMealDataList){
                this.dailyMealDataList = dailyMealDataList;
                notifyDataSetChanged();
        }
        
        
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                
                
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                View itemView = inflater.inflate(R.layout.card_meal, parent, false);
                return new DailyMealViewHolder(itemView,  context, onItemClickCallback);
        }
        
        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                DailyMealViewHolder dailyMealViewHolder = (DailyMealViewHolder)holder;
        
                DailyMealContainerModel dailyMealData = dailyMealDataList.get(position);
                
                dailyMealViewHolder.BindViewithData(dailyMealData);
        }
        
        @Override
        public int getItemCount() {
                return  dailyMealDataList != null ? dailyMealDataList.size() : 0;
        }
}