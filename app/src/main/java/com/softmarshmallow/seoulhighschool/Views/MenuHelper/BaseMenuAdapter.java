package com.softmarshmallow.seoulhighschool.Views.MenuHelper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softmarshmallow.seoulhighschool.Models.MealMenuModel;
import com.softmarshmallow.seoulhighschool.R;

import java.util.List;

import io.reactivex.functions.Consumer;

public class BaseMenuAdapter extends RecyclerView.Adapter
{
        private static final String TAG = "BaseMealAdapter";
        private final Context context;
        public List<MealMenuModel> mealMenuModels;
        private Consumer<MealMenuModel> onItemClickCallback = new Consumer<MealMenuModel>()
        {
                @Override
                public void accept(MealMenuModel mealMenuModel) throws Exception {
                        Log.d(TAG, "Clicked : " + mealMenuModel.toString());
                }
        };
        
        public BaseMenuAdapter(Context context, List<MealMenuModel> mealMenuModels){
                
                this.context = context;
                this.mealMenuModels = mealMenuModels;
        }
        
        public void updateData(List<MealMenuModel> mealMenuModels){
                this.mealMenuModels = mealMenuModels;
                notifyDataSetChanged();
        }
        
        
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                
                
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                View itemView = inflater.inflate(R.layout.card_meal_menu_small, parent, false);
                return new MenuCardViewHolder(itemView,  context, onItemClickCallback);
        }
        
        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                MenuCardViewHolder mealViewHolder = (MenuCardViewHolder)holder;
        
                MealMenuModel MealData = mealMenuModels.get(position);
                
                mealViewHolder.BindViewWithData(MealData);
        }
        
        @Override
        public int getItemCount() {
                return  mealMenuModels != null ? mealMenuModels.size() : 0;
        }
}