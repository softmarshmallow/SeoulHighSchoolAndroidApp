package com.softmarshmallow.seoulhighschool.Views.TimeTableEditor;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;
import com.softmarshmallow.seoulhighschool.Models.TimeTable.DayType;
import com.softmarshmallow.seoulhighschool.Models.TimeTable.TimeTableItemModel;
import com.softmarshmallow.seoulhighschool.R;
import com.softmarshmallow.seoulhighschool.Services.TimeTableService;
import com.softmarshmallow.seoulhighschool.Views.Development.RecyclerViewFragment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.functions.Consumer;

/**
 * Created by uzu on 10/30/17.
 */

public class TimeTable_DayScheduleEditorFragment extends Fragment
{
        
        
        
        
        
        //region
        
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private static final String ARG_DAY_TYPE = "day_type";
        private static final String TAG = "EditorFragment";
        
        // TODO: Rename and change types of parameters
        private DayType dayType;
        // e.g. Calendar.MONDAY
        
        
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param dayType Type of the day // monday, tuesday
         * @return A new instance of fragment SchoolIntroduction_Greetings.
         */
        // TODO: Rename and change types and number of parameters
        public static TimeTable_DayScheduleEditorFragment newInstance(DayType dayType) {
                TimeTable_DayScheduleEditorFragment fragment = new TimeTable_DayScheduleEditorFragment();
                Bundle args = new Bundle();
                args.putInt(ARG_DAY_TYPE, dayType.getValue());
                fragment.setArguments(args);
                return fragment;
        }
        
        public static RecyclerViewFragment newInstance() {
                return new RecyclerViewFragment();
        }
        
        public TimeTable_DayScheduleEditorFragment() {
                // Required empty public constructor
        }
        
        @Override
        public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                if (getArguments() != null) {
                        dayType = DayType.getEnum(getArguments().getInt(ARG_DAY_TYPE));
                }
        }
        //endregion
        
        
        @BindView(R.id.recyclerView)
        RecyclerView mRecyclerView;
        
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
                return inflater.inflate(R.layout.fragment_recyclerview, container, false);
        }
        
        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
                super.onViewCreated(view, savedInstanceState);
                ButterKnife.bind(this, view);
        
                initRecyclerView();
        }
        
        TimeTableListAdapter adapter;
        
        void initRecyclerView(){
        
                //setup materialviewpager
                mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                mRecyclerView.setHasFixedSize(true);
                
                //Use this now
                mRecyclerView.addItemDecoration(new MaterialViewPagerHeaderDecorator());
                adapter = new TimeTableListAdapter(getContext(),
                        timeTableItemDataList);
                mRecyclerView.setAdapter(adapter);
        
        
                updateTimeTableItemData();
        }
        
        // region
        List<TimeTableItemModel> timeTableItemDataList = new ArrayList<>();
        
        void updateTimeTableItemData(){
                Log.d(TAG, "updateTimeTableItemData");
                
                
                TimeTableService.getDayTimeTableRow(dayType,
                        new Consumer<List<TimeTableItemModel>>()
                        {
                                @Override
                                public void accept(List<TimeTableItemModel> timeTableItemModels) throws Exception {
                                        timeTableItemDataList = timeTableItemModels;
                                        Log.d(TAG, "SIZE = " + timeTableItemDataList.size());
                                        adapter.updateData(
                                                timeTableItemDataList);
                                        
                                }
                        }, new Consumer<String>()
                        {
                                @Override
                                public void accept(String s) throws Exception {
                                        
                                }
                        }
                );
        }
      
        //endregion
}
