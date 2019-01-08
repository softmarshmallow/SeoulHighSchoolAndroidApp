package com.softmarshmallow.seoulhighschool.Views.RatingCalculator;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.simplelist.MaterialSimpleListAdapter;
import com.afollestad.materialdialogs.simplelist.MaterialSimpleListItem;
import com.softmarshmallow.seoulhighschool.Models.RatingCalculation.RatingCalculationItemModel;
import com.softmarshmallow.seoulhighschool.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;


public class RatingCalculationItemViewHolder extends RecyclerView.ViewHolder
{
        private static final String TAG = "RatingItemViewHolder";
        
        
        
        @BindView(R.id.indexTextView)
        TextView indexTextView;
        
        @BindView(R.id.numberOfDaysCountEditText)
        EditText numberOfDaysCountEditText;
        @BindView(R.id.gradeEditText)
        EditText gradeEditText;
        
        private Context context;
        private RatingCalculationItemModel ratingCalculationItemModel;
        
        public RatingCalculationItemViewHolder(View itemView, final Context context) {
                super(itemView);
                ButterKnife.bind(this, itemView);
                this.context = context;
        
                initEditText();

        }
        
        
        void initEditText(){
                numberOfDaysCountEditText.addTextChangedListener(new TextWatcher()
                {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                
                        }
        
                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                                try {
                                        ratingCalculationItemModel.totalAmount = Integer.parseInt( charSequence.toString());
                                }catch (NumberFormatException ex){
                                        onInvalidInput();
                                }
                        }
        
                        @Override
                        public void afterTextChanged(Editable editable) {
                        }
                });
        
        
                gradeEditText.addTextChangedListener(new TextWatcher()
                {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                
                        }
        
                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                                try{
                                        ratingCalculationItemModel.rate = Integer.parseInt( charSequence.toString());
                                }
                                catch (NumberFormatException ex){
                                        onInvalidInput();
                                }
        
                        }
        
                        @Override
                        public void afterTextChanged(Editable editable) {
                
                        }
                });
                
                
        }
        
        
        private void onInvalidInput(){
                new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
                        .setTitleText("올바르지 않은 입력입니다.")
                        .setContentText("입력을 비워두지 말아주세요")
                        .show();
                
        }
        

        public void BindViewWithData(RatingCalculationItemModel ratingCalculationItemModel) {
                this.ratingCalculationItemModel = ratingCalculationItemModel;
//                indexTextView.setText(String.valueOf( ratingCalculationItemModel.index) + " 교시");
                indexTextView.setText(ratingCalculationItemModel.index + " 번 과목");
                updateData();
        }
        
        private void updateData(){
//                contentTextView.setText(ratingCalculationItemModel.content);
        }
}
