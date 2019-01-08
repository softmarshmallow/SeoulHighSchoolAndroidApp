package com.softmarshmallow.seoulhighschool.Views.MealListHelpers.MealList;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.softmarshmallow.seoulhighschool.Helpers.DateFormatHelper;
import com.softmarshmallow.seoulhighschool.Models.MealModel;
import com.softmarshmallow.seoulhighschool.R;
import com.softmarshmallow.seoulhighschool.Views.MenuHelper.BaseMenuAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.functions.Consumer;


public class MealCardViewHolder extends RecyclerView.ViewHolder
{
        // TODO: 10/25/17
        @BindView(R.id.mealDateTextView)
        TextView mealDateText;

        @BindView(R.id.captionText)
        TextView mealTypeText;
        
        @BindView(R.id.recyclerView)
        RecyclerView recyclerView;

        @BindView(R.id.thumbnailImageView)
        ImageView thumbnailImageView;
        private Context context;
        private MealModel mealData;


        public MealCardViewHolder(View itemView, final Context context, final Consumer<MealModel> onclick) {
                super(itemView);
                ButterKnife.bind(this, itemView);
                this.context = context;
                itemView.setOnClickListener(new View.OnClickListener()
                {
                        @Override
                        public void onClick(View view) {
                                try {
                                        onclick.accept(mealData);
                                }
                                catch (Exception e) {
                                        e.printStackTrace();
                                }
                        }
                });
        }
        
        public void BindViewWithData(MealModel mealData) {
                this.mealData = mealData;
                mealDateText.setText(DateFormatHelper.getDefaultDateFormat( mealData.date));
                mealTypeText.setText(mealData.mealType.toString());
                initRecyclerView();

        }
        
        
        BaseMenuAdapter menuAdapter;
        void initRecyclerView(){
                menuAdapter = new BaseMenuAdapter(context, mealData.menus);
                recyclerView.setAdapter(menuAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
        }
        
}
