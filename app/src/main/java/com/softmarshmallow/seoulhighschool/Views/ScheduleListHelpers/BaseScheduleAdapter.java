package com.softmarshmallow.seoulhighschool.Views.ScheduleListHelpers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softmarshmallow.seoulhighschool.Models.AcademicScheduleModel;
import com.softmarshmallow.seoulhighschool.Models.MealModel;
import com.softmarshmallow.seoulhighschool.R;

import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;
import io.reactivex.functions.Consumer;

public class BaseScheduleAdapter extends RecyclerView.Adapter
{
        private static final String TAG = "BaseScheduleAdapter";
        private final Context context;
        private List<AcademicScheduleModel> scheduleList;
        private Consumer<AcademicScheduleModel> onItemClickCallback = new Consumer<AcademicScheduleModel>()
        {
                @Override
                public void accept(AcademicScheduleModel scheduleModel) throws Exception {
                        Log.d(TAG, "Clicked : " + scheduleModel.toString());
                        new SweetAlertDialog(context, SweetAlertDialog.NORMAL_TYPE).setContentText(scheduleModel.toString()).show();
        
                }
        };
        
        public BaseScheduleAdapter(Context context, List<AcademicScheduleModel> scheduleList){
                
                this.context = context;
                this.scheduleList = scheduleList;
        }
        
        public void updateData(List<AcademicScheduleModel> scheduleList){
                this.scheduleList = scheduleList;
                notifyDataSetChanged();
        }
        
        
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                
                
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                View itemView = inflater.inflate(R.layout.card_schedule, parent, false);
                return new ScheduleCardViewHolder(itemView,  context, onItemClickCallback);
        }
        
        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                ScheduleCardViewHolder scheduleCardViewHolder = (ScheduleCardViewHolder)holder;
                
                AcademicScheduleModel scheduleModel = scheduleList.get(position);
                
                scheduleCardViewHolder.BindViewWithData(scheduleModel);
        }
        
        @Override
        public int getItemCount() {
                return  scheduleList != null ? scheduleList.size() : 0;
        }
}