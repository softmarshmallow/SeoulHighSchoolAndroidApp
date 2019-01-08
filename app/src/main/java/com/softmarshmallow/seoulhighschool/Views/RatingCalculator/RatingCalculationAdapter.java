package com.softmarshmallow.seoulhighschool.Views.RatingCalculator;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softmarshmallow.seoulhighschool.Models.RatingCalculation.RatingCalculationItemModel;
import com.softmarshmallow.seoulhighschool.Models.TimeTable.TimeTableItemModel;
import com.softmarshmallow.seoulhighschool.R;

import java.util.List;

public class RatingCalculationAdapter extends RecyclerView.Adapter
{
        private static final String TAG = "RatingCalculationAdapter";
        private final Context context;
        private List<RatingCalculationItemModel> ratingCalculationItemModelList;

        
        public RatingCalculationAdapter(Context context, List<RatingCalculationItemModel> ratingCalculationItemModelList){
                
                this.context = context;
                this.ratingCalculationItemModelList = ratingCalculationItemModelList;
        }
        
        public void updateData(List<RatingCalculationItemModel> timeTableItemModels){
                this.ratingCalculationItemModelList = timeTableItemModels;
                notifyDataSetChanged();
        }
        
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                View itemView = inflater.inflate(R.layout.card_rating_calculation_item, parent, false);
                return new RatingCalculationItemViewHolder(itemView,  context);
        }
        
        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                RatingCalculationItemViewHolder ratingCalculationItemViewHolder = (RatingCalculationItemViewHolder)holder;
        
                RatingCalculationItemModel ratingCalculationItemModel = ratingCalculationItemModelList.get(position);
                
                ratingCalculationItemViewHolder.BindViewWithData(ratingCalculationItemModel);
        }
        
        @Override
        public int getItemCount() {
                return  ratingCalculationItemModelList != null ? ratingCalculationItemModelList.size() : 0;
        }
}