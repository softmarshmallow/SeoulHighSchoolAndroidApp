package com.softmarshmallow.seoulhighschool.Views.MealDetailPage;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.like.LikeButton;
import com.like.OnLikeListener;
import com.ms.square.android.expandabletextview.ExpandableTextView;
import com.softmarshmallow.seoulhighschool.Models.MealModel;
import com.softmarshmallow.seoulhighschool.R;
import com.softmarshmallow.seoulhighschool.Views.MealListHelpers.MealList.BaseMealAdapter;
import com.softmarshmallow.seoulhighschool.Views.MenuHelper.BaseMenuAdapter;
import com.softmarshmallow.seoulhighschool.Views.Shared.GridSpacingItemDecoration;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

import static com.softmarshmallow.seoulhighschool.Helpers.SchoolInfoConfig.CAFETERIA_PHONE_NUMBER;

public class MealDetailPageActivity extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener
{
        
        
        private static final String TAG = "MealDetailPageActivity";
        //region views
        @BindView(R.id.appbar)
        AppBarLayout appBarLayout;
        
        @BindView(R.id.toolbar)
        Toolbar toolbar;
        
        @BindView(R.id.storeFeatureGraphicImageView)
        ImageView mealFeatureGraphicImageView;
        
        @BindView(R.id.mealNameTextView)
        TextView mealNameTextView;
        
        @BindView(R.id.mealShortDescriptionTextView)
        TextView mealShortDescriptionTextView;
        
        @BindView(R.id.mealFullDescriptionExpandableTextView)
        ExpandableTextView mealFullDescriptionExpandableTextView;
        
        @BindView(R.id.mealDetailMenusRecyclerView)
        RecyclerView menusRecyclerView;
        
        @BindView(R.id.mealReviewsRecyclerView)
        RecyclerView reviewsRecyclerView;
        
        
        BaseMenuAdapter menusAdapter;
//        ReviewsAdapter reviewsAdapter;
        
        static MealModel mealDataToDisplay;
        
        
        public static void StartActivity(Context context, MealModel mealDataToDisplay) {
                MealDetailPageActivity.mealDataToDisplay = mealDataToDisplay;
                context.startActivity(new Intent(context, MealDetailPageActivity.class));
        }
        
        
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_meal_detail_page);
                ButterKnife.bind(this);
/*

                //pushable activity
                Slidr.attach(this);
*/
                
                
                toolbar.setTitleTextColor(Color.RED);
                
                //region Init
                
                setSupportActionBar(toolbar);
                
                // Init CollapsingToolbar
                InitCollapsingToolbar();

                // init like button
                InitLikeButton();
                
                loadMealData();
                
                
        }
        
        
        public void loadMealData() {
                
                Thread t = new Thread(new Runnable()
                {
                        @Override
                        public void run() {
                                loadMealDataInBackground();
                        }
                });
                t.run();
        }
        
        public void loadMealDataInBackground() {
                
                runOnUiThread(new Runnable()
                {
                        @Override
                        public void run() {
                                updateMealInfo();
                                
                                initMealMenusRecyclerView();
                                
//                                initStoreReviewsRecyclerView();
                                
                                updateContacts();
                                
                                
                        }
                });
                
        }
        
        
        
        
        
        void updateMealInfo(){
                
                // MealName
                mealNameTextView.setText(mealDataToDisplay.getMealTitle());
                // MealShortDescription
                mealShortDescriptionTextView.setText(
                        mealDataToDisplay.getMealShortDescription());
                // StoreFullDescription
                mealFullDescriptionExpandableTextView.setText(
                        mealDataToDisplay.getMealFullDescription());
                
                
        }
        
        
        //region Menus
        void initMealMenusRecyclerView(){
        
        
                LinearLayoutManager mealRecyclerviewRecyclerViewLayoutManager = new LinearLayoutManager(
                        this, LinearLayoutManager.VERTICAL, false);
                menusRecyclerView.setLayoutManager(mealRecyclerviewRecyclerViewLayoutManager);
                menusAdapter = new BaseMenuAdapter(this, mealDataToDisplay.menus);
                menusRecyclerView.setAdapter(menusAdapter);
                
                
                /*
                
                
                RecyclerView.LayoutManager menusLayoutManager = new GridLayoutManager(this, 2);
                menusAdapter = new BaseMenuAdapter(this, mealDataToDisplay.menus);
                menusRecyclerView.setLayoutManager(menusLayoutManager);
                menusRecyclerView.addItemDecoration(
                        new GridSpacingItemDecoration(2,
                                GridSpacingItemDecoration.ConvertPixelsToDp(10), true));
                menusRecyclerView.setItemAnimator(new DefaultItemAnimator());
                menusRecyclerView.setAdapter(menusAdapter);
                */
                updateMealMenus();
                
                
                Log.d(TAG, "size : menusAdapter.mealMenuModels.size() :::: " + menusAdapter.mealMenuModels.size() + "");
                
        }
        
        void updateMealMenus() {
                
                // Menus
                
                
        }
        //endregion
        
        /*
        //region Reviews
        void initStoreReviewsRecyclerView() {
                reviewsAdapter = new ReviewsAdapter(this);
                
                // Reviews
                RecyclerView.LayoutManager reviewsLayoutManager = new LinearLayoutManager(this);
                
                reviewsRecyclerView.setLayoutManager(reviewsLayoutManager);
                reviewsRecyclerView.addItemDecoration(
                        new GridSpacingItemDecoration(2,
                                GridSpacingItemDecoration.ConvertPixelsToDp(10), true));
                reviewsRecyclerView.setItemAnimator(new DefaultItemAnimator());
                reviewsRecyclerView.setAdapter(reviewsAdapter);
                
                updateStoreReviews();
        }
        
        void updateStoreReviews(){
                
                // Load & Update Review Datas
                mealDataToDisplay.StoreReviews = new ArrayList<>();
                for (String storeReviewsIdsHashKey : mealDataToDisplay.StoreReviewsIds.keySet()) {
                        String storeReviewId = mealDataToDisplay.StoreReviewsIds.get(
                                storeReviewsIdsHashKey);
                        StoreReviewService.GetStoreReview(
                                storeReviewId,
                                new Consumer<StoreReviewModel>()
                                {
                                        @Override
                                        public void accept(StoreReviewModel storeReviewModel) throws Exception {
                                                mealDataToDisplay.StoreReviews.add(
                                                        storeReviewModel);
                                                List<? extends ReviewModel> reviews = mealDataToDisplay.StoreReviews;
                                                reviewsAdapter.UpdateReviews(
                                                        (List<ReviewModel>) reviews);
                                        }
                                }, new Consumer<String>()
                                {
                                        @Override
                                        public void accept(String databaseError) throws Exception {
                                                Log.e(TAG, databaseError);
                                        }
                                });
                }
        }
        //endregion
        */
        //region Contacts
        @BindView(R.id.phoneNumberTextView)
        TextView phoneNumberTextView;
        
        void updateContacts(){
                phoneNumberTextView.setText(CAFETERIA_PHONE_NUMBER);
        }
        
        //endregion
        
       
        void InitCollapsingToolbar() {
                final CollapsingToolbarLayout collapsingToolbar =
                        (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
                collapsingToolbar.setTitle(" ");
                AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
                appBarLayout.setExpanded(true);
                
                // hiding & showing the title when toolbar expanded & collapsed
                
                
                appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener()
                {
                        boolean isShow = false;
                        int scrollRange = -1;
                        
                        @Override
                        public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                                if (scrollRange == -1) {
                                        scrollRange = appBarLayout.getTotalScrollRange();
                                }
                                if (scrollRange + verticalOffset == 0) {
                                        collapsingToolbar.setTitle(mealDataToDisplay.getMealTitle());
                                        this.isShow = true;
                                } else if (isShow) {
                                        collapsingToolbar.setTitle("");
                                        isShow = false;
                                }
                        }
                });
                
        }
        
        
        void InitLikeButton() {
                LikeButton likeButton = findViewById(R.id.likeButton);
                likeButton.setOnLikeListener(new OnLikeListener()
                {
                        @Override
                        public void liked(LikeButton likeButton) {
                                /*new SweetAlertDialog(StoreDetailViewActivity.this)
                                        .setTitleText("Liked!")
                                        .show();*/
                                
                        }
                        
                        @Override
                        public void unLiked(LikeButton likeButton) {
                                /*new SweetAlertDialog(StoreDetailViewActivity.this)
                                        .setTitleText("UnLiked!")
                                        .show();*/
                                
                        }
                });
        }
        
        
        @OnClick(R.id.shareOptionContainer)
        void OnShareOptionClick() {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, mealDataToDisplay.getMealFullDescription());
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
        }
        
        @OnClick(R.id.writeReviewOptionContainer)
        void OnWriteReviewOptionClick() {
                MealReviewCreatorActivity.StartActivity(mealDataToDisplay.getUID(),
                        this);
        }
        
        @Override
        protected void onResume() {
                super.onResume();
                appBarLayout.addOnOffsetChangedListener(this);
        }
        
        @Override
        protected void onPause() {
                super.onPause();
                appBarLayout.removeOnOffsetChangedListener(this);
        }
        
        //endregion
        
        @Override
        protected void attachBaseContext(Context newBase) {
                super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
        }
        
        
        @Override
        public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                
        }
}
