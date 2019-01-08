package com.softmarshmallow.seoulhighschool.Views.TimeTableEditor;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.softmarshmallow.seoulhighschool.Helpers.DayTypeLocalizationHelper;
import com.softmarshmallow.seoulhighschool.Models.TimeTable.TimeTableItemModel;
import com.softmarshmallow.seoulhighschool.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class TimeTableItemViewHolder extends RecyclerView.ViewHolder
{
        private static final String TAG = "TableItemViewHolder";
        @BindView(R.id.contentTextView)
        TextView contentTextView;
        @BindView(R.id.indexTextView)
        TextView indexTextView;
        
        private Context context;
        private TimeTableItemModel timeTableItemData;


        public TimeTableItemViewHolder(View itemView, final Context context) {
                super(itemView);
                ButterKnife.bind(this, itemView);
                this.context = context;
                itemView.setOnClickListener(new View.OnClickListener()
                {
                        @Override
                        public void onClick(View view) {
                                Log.d(TAG, "Clicked : " + timeTableItemData.toString());
                                
                                new MaterialDialog.Builder(context)
                                        .title(DayTypeLocalizationHelper.getDayTypeLocalizedString("ko", timeTableItemData.dayType) +", " + timeTableItemData.index + "교시")
                                        .content("시간표를 입력해주세요.")
                                        .inputType(InputType.TYPE_CLASS_TEXT)
                                        .input("예) 과학", "",
                                                new MaterialDialog.InputCallback()
                                                {
                                                        @Override
                                                        public void onInput(@NonNull MaterialDialog dialog, CharSequence input) {
                                                                timeTableItemData.content  = input.toString();
                                                                
                                                        }
                                                })
                                        .onAny(new MaterialDialog.SingleButtonCallback()
                                        {
                                                @Override
                                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                                        timeTableItemData();
                                                        timeTableItemData.save();
                                                }
                                        })
                                        .show();
                        }
                });
        }

        public void BindViewWithData(TimeTableItemModel timeTableItemModel) {
                this.timeTableItemData = timeTableItemModel;
                indexTextView.setText(String.valueOf( timeTableItemModel.index) + " 교시");
                timeTableItemData();
        }
        
        private void timeTableItemData(){
                contentTextView.setText(timeTableItemData.content);
        }
}
