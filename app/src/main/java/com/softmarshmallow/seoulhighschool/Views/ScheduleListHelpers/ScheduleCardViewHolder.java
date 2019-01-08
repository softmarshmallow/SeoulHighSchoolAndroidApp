package com.softmarshmallow.seoulhighschool.Views.ScheduleListHelpers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.softmarshmallow.seoulhighschool.Helpers.D_DayCalculator;
import com.softmarshmallow.seoulhighschool.Helpers.DateFormatHelper;
import com.softmarshmallow.seoulhighschool.Models.AcademicScheduleModel;
import com.softmarshmallow.seoulhighschool.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.functions.Consumer;


public class ScheduleCardViewHolder extends RecyclerView.ViewHolder
{
        @BindView(R.id.scheduleContentTextView)
        TextView scheduleContentTextView;

        @BindView(R.id.scheduleDateTextView)
        TextView scheduleDateTextView;
        
        @BindView(R.id.captionText)
        TextView captionText;

        private Context context;
        private AcademicScheduleModel scheduleData;


        public ScheduleCardViewHolder(View itemView, final Context context, final Consumer<AcademicScheduleModel> onclick) {
                super(itemView);
                ButterKnife.bind(this, itemView);
                this.context = context;
                itemView.setOnClickListener(new View.OnClickListener()
                {
                        @Override
                        public void onClick(View view) {
                                try {
                                        onclick.accept(scheduleData);
                                }
                                catch (Exception e) {
                                        e.printStackTrace();
                                }
                        }
                });
        }

        public void BindViewWithData(AcademicScheduleModel scheduleData) {
                this.scheduleData = scheduleData;
                scheduleDateTextView.setText(DateFormatHelper.getDefaultDateFormat( scheduleData.date));
                scheduleContentTextView.setText(scheduleData.scheduleContent);
                captionText.setText("D- " + D_DayCalculator.getD_Day(scheduleData.date.getYear(), scheduleData.date.getMonth(), scheduleData.date.getDate()));
        }
}
