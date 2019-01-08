package com.softmarshmallow.seoulhighschool.Views.MainPage;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.softmarshmallow.seoulhighschool.Helpers.SchoolInfoConfig;
import com.softmarshmallow.seoulhighschool.R;
import com.softmarshmallow.seoulhighschool.Views.DictionarySearch.DictionarySearchActivity;
import com.softmarshmallow.seoulhighschool.Views.MealListHelpers.MealActivity;
import com.softmarshmallow.seoulhighschool.Views.RatingCalculator.RatingCalculatorActivity;
import com.softmarshmallow.seoulhighschool.Views.SchoolIntoduction.SchoolIntroductionActivity;
import com.softmarshmallow.seoulhighschool.Views.TimeTableEditor.TimeTableEditorActivity;


class MainNavigationDrawer
{

        private static  final String TAG = "MainNavigationDrawer";

        enum NavigationItemType{
                Option0(0),
                Option1(1),
                Option2(2),
                Option3(3),
                Option4(4),
                Option5(5),
                Option6(6);


                int value;
                NavigationItemType(int value) {
                this.value = value;
                }

                public int getValue() {
                        return value;
                }


                public static NavigationItemType  getEnum(int value) {
                        for (NavigationItemType e: NavigationItemType.values()) {
                                if(e.getValue() == value)
                                        return e;
                        }
                        return  null;
                }
        }

 
        
        
        
        
        
        static DrawerBuilder CreateNavigationDrawer(final Activity activity, Toolbar toolbar) {
                SecondaryDrawerItem droneCreator = new SecondaryDrawerItem().withIdentifier(
                        NavigationItemType.Option0.getValue()).withName("그읍식");
                SecondaryDrawerItem option1 = new SecondaryDrawerItem().withIdentifier(
                        NavigationItemType.Option1.getValue()).withName("입시 용어 사전");
                SecondaryDrawerItem option2 = new SecondaryDrawerItem().withIdentifier(
                        NavigationItemType.Option2.getValue()).withName("학교 소개");
                SecondaryDrawerItem option3 = new SecondaryDrawerItem().withIdentifier(
                        NavigationItemType.Option3.getValue()).withName("시간표 수정");
                SecondaryDrawerItem option4 = new SecondaryDrawerItem().withIdentifier(
                        NavigationItemType.Option4.getValue()).withName("등급 계산기");
                SecondaryDrawerItem option5 = new SecondaryDrawerItem().withIdentifier(
                        NavigationItemType.Option5.getValue()).withName("대신 전해드려요");
                SecondaryDrawerItem option6 = new SecondaryDrawerItem().withIdentifier(
                        NavigationItemType.Option6.getValue()).withName("방송부 사연신청");
        
        
        
                // Create the AccountHeader
                AccountHeader headerResult = new AccountHeaderBuilder()
                        .withActivity(activity)
                        .withHeaderBackground(R.drawable.splash_screen_background)
                        .withHeaderBackgroundScaleType(ImageView.ScaleType.CENTER_CROP)
/*                        .addProfiles(
                                new ProfileDrawerItem().withName(FirebaseUserService.getDisplayName()).withEmail(FirebaseUserService.getUserEmail()).withIcon(R.drawable.app_icon)
                        )
                        .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                                @Override
                                public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                                        return true;
                                }
                        })*/
                        .build();
        
        
                //create the drawer and remember the `Drawer` result object
        
                DrawerBuilder builder = new DrawerBuilder()
                        .withActivity(activity)
//                        .withToolbar(toolbar)
                        .withAccountHeader(headerResult)
                        .addDrawerItems(
                                droneCreator,
                                option1,
                                option2,
                                option3,
                                option4,
                                option5,
                                option6
                        )
                        .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                        
                                @Override
                                public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                                
                                        // do something with the clicked item :D
                                        Log.d(TAG, "onItemClick : position = " + position + ", identifier = " + drawerItem.getIdentifier());
                                        NavigationItemType navigationItemType = NavigationItemType.getEnum(
                                                (int) drawerItem.getIdentifier());
                                        
                                        Intent intent;
                                        switch (navigationItemType){
                                        
                                                case Option0:
                                                        intent = new Intent(activity, MealActivity.class);
                                                        activity.startActivity(intent);
                                                        break;
                                                        
                                                case Option1:
                                                        intent = new Intent(activity, DictionarySearchActivity.class);
                                                        activity.startActivity(intent);
                                                        break;
                                                        
                                                case  Option2:
                                                        intent = new Intent(activity, SchoolIntroductionActivity.class);
                                                        activity.startActivity(intent);
                                                        break;
                                                case Option3:
                                                        intent = new Intent(activity, TimeTableEditorActivity.class);
                                                        activity.startActivity(intent);
                                                        break;
                                                
                                                case Option4:
                                                        intent = new Intent(activity, RatingCalculatorActivity.class);
                                                        activity.startActivity(intent);
                                                        break;
                                                
                                                case Option5:
                                                        Intent i = new Intent(Intent.ACTION_VIEW);
                                                        i.setData(Uri.parse(SchoolInfoConfig.FACEBOOK_ANONYMOUS_PAGE_URL));
                                                        activity.startActivity(i);
                                                        break;
                                                          
                                                case Option6:
                                                        Intent intent1 = new Intent(Intent.ACTION_VIEW);
                                                        intent1.setData(Uri.parse(SchoolInfoConfig.FACEBOOK_BROADCAST_PAGE_URL));
                                                        activity.startActivity(intent1);
                                                        break;
                                        }
                                
                                        return  true;
                                }
                        });
        
                return builder;
        }
        
        public static View GetNavigationDrawerView(final Activity activity, Toolbar toolbar) {
                DrawerBuilder builder = CreateNavigationDrawer( activity,toolbar);
                return builder.buildView().getSlider();
        }
        
        public static void DrawNavigationBar(final Activity activity, Toolbar toolbar) {
                DrawerBuilder builder = CreateNavigationDrawer( activity,toolbar);
                builder.build();
        }


}
