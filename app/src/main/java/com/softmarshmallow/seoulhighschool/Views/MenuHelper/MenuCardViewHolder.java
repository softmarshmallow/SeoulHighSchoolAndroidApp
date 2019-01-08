package com.softmarshmallow.seoulhighschool.Views.MenuHelper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.softmarshmallow.seoulhighschool.Models.MealMenuModel;
import com.softmarshmallow.seoulhighschool.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.functions.Consumer;


public class MenuCardViewHolder extends RecyclerView.ViewHolder
{
        // TODO: 10/25/17
        @BindView(R.id.contentTextView)
        TextView contentText;
        
        private Context context;
        private MealMenuModel mealMenuModel;


        public MenuCardViewHolder(View itemView, final Context context, final Consumer<MealMenuModel> onclick) {
                super(itemView);
                ButterKnife.bind(this, itemView);
                this.context = context;
                itemView.setOnClickListener(new View.OnClickListener()
                {
                        @Override
                        public void onClick(View view) {
                                try {
                                        onclick.accept(mealMenuModel);
                                }
                                catch (Exception e) {
                                        e.printStackTrace();
                                }
                        }
                });
        }

        public void BindViewWithData(MealMenuModel mealData) {
                this.mealMenuModel = mealData;
                contentText.setText(mealData.menuName);

        }
}
