package com.softmarshmallow.seoulhighschool.Models;

import com.softmarshmallow.seoulhighschool.Helpers.SchoolInfoConfig;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by uzu on 10/23/17.
 */

public class MealModel
{
        public String rawData;
        public List<MealMenuModel> menus = new ArrayList<>();
        public Date date;
        public MealType mealType;
        
        
        //region extra fields
        public String getUID(){
                return SchoolInfoConfig.SEOUL_HS_SCHOOL_CODE + date.toString() + mealType.toString();
        }
        
        public String getMealTitle(){
                return date.toString() + " : " + mealType.toString();
        }
        
        public String getMealShortDescription(){
                return this.toString();
        }
        
        public String getMealFullDescription(){
                return this.toString();
        }
        //endregion
        
        
        @Override
        public String toString() {
                return "menus : " + rawData + "\n" + "At : " + date + "\n" + "Type : " + mealType.toString();
        }
}
