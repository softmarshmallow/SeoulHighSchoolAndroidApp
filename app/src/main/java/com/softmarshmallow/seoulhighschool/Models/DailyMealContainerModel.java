package com.softmarshmallow.seoulhighschool.Models;


import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class DailyMealContainerModel
{
       public MealModel breakfastMeal;
       public MealModel launchMeal;
       public MealModel dinnerMeal;
       
       public Map<MealType, MealModel> getAsDictionary(){
              return new HashMap<MealType, MealModel>()
              {
                     {
                            put(MealType.Breakfast, breakfastMeal);
                            put(MealType.Launch, launchMeal);
                            put(MealType.Dinner, dinnerMeal);
                     }
              };
       }
}
