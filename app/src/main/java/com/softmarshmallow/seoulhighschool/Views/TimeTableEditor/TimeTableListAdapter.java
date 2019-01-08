package com.softmarshmallow.seoulhighschool.Views.TimeTableEditor;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softmarshmallow.seoulhighschool.Models.TimeTable.TimeTableItemModel;
import com.softmarshmallow.seoulhighschool.R;

import java.util.List;

public class TimeTableListAdapter extends RecyclerView.Adapter
{
        private static final String TAG = "TimeTableListAdapter";
        private final Context context;
        private List<TimeTableItemModel> timeTableItemModels;
        
        
        public TimeTableListAdapter(Context context, List<TimeTableItemModel> timeTableItemModels){
                
                this.context = context;
                this.timeTableItemModels = timeTableItemModels;
        }
        
        public void updateData(List<TimeTableItemModel> timeTableItemModels){
                this.timeTableItemModels = timeTableItemModels;
                notifyDataSetChanged();
        }
        
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                View itemView = inflater.inflate(R.layout.card_time_table_item_editor, parent, false);
                return new TimeTableItemViewHolder(itemView,  context);
        }
        
        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                TimeTableItemViewHolder timeTableItemViewHolder = (TimeTableItemViewHolder)holder;
        
                TimeTableItemModel timeTableItemModel = timeTableItemModels.get(position);
                
                timeTableItemViewHolder.BindViewWithData(timeTableItemModel);
        }
        
        @Override
        public int getItemCount() {
                return  timeTableItemModels != null ? timeTableItemModels.size() : 0;
        }
}