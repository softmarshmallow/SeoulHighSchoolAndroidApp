package com.softmarshmallow.seoulhighschool.Views.DictionarySearch;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softmarshmallow.seoulhighschool.Models.AcademicScheduleModel;
import com.softmarshmallow.seoulhighschool.Models.WordDictionary.VocabularyModel;
import com.softmarshmallow.seoulhighschool.R;

import java.util.List;

import io.reactivex.functions.Consumer;

public class BaseVocaAdapter extends RecyclerView.Adapter
{
        private static final String TAG = "BaseScheduleAdapter";
        private final Context context;
        private List<VocabularyModel> vocabularyModelList;
        private Consumer<VocabularyModel> onItemClickCallback = new Consumer<VocabularyModel>()
        {
                @Override
                public void accept(VocabularyModel vocabularyModel) throws Exception {
                        Log.d(TAG, "Clicked : " + vocabularyModel.toString());
                }
        };
        
        public BaseVocaAdapter(Context context, List<VocabularyModel> vocabularyModelList){
                
                this.context = context;
                this.vocabularyModelList = vocabularyModelList;
        }
        
        public void updateData(List<VocabularyModel> vocabularyModelList){
                this.vocabularyModelList = vocabularyModelList;
                notifyDataSetChanged();
        }
        
        
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                
                
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                View itemView = inflater.inflate(R.layout.card_voca, parent, false);
                return new VocaCardViewHolder(itemView,  context, onItemClickCallback);
        }
        
        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                VocaCardViewHolder vocaCardViewHolder = (VocaCardViewHolder)holder;
        
                VocabularyModel vocabularyModel = vocabularyModelList.get(position);
                
                vocaCardViewHolder.BindViewWithData(vocabularyModel);
        }
        
        @Override
        public int getItemCount() {
                return  vocabularyModelList != null ? vocabularyModelList.size() : 0;
        }
}