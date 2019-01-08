package com.softmarshmallow.seoulhighschool.Views.DictionarySearch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.SearchView;
import android.widget.TextView;

import com.softmarshmallow.seoulhighschool.Models.WordDictionary.VocabularyDataSource;
import com.softmarshmallow.seoulhighschool.Models.WordDictionary.VocabularyModel;
import com.softmarshmallow.seoulhighschool.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DictionarySearchActivity extends AppCompatActivity
{
        
        @BindView(R.id.autotext)
        SearchView autotext;
     
        
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_dictionary_search);
                ButterKnife.bind(this);
        
                initSearchView();
        
                initVocaRecyclerView();
        }
        
        
        void initSearchView(){
                autotext.setOnQueryTextListener(new SearchView.OnQueryTextListener()
                {
                        @Override
                        public boolean onQueryTextSubmit(String s) {
                                searchVoca(s);
                                return false;
                        }
        
                        @Override
                        public boolean onQueryTextChange(String s) {
                                return false;
                        }
                });
        }
        
        
        //region
        @BindView(R.id.recyclerView)
        RecyclerView vocaRecyclerView;
        BaseVocaAdapter vocaAdapter;
        List<VocabularyModel> vocaDataList = VocabularyDataSource.vocabularyModelList;
        void initVocaRecyclerView() {
                vocaAdapter = new BaseVocaAdapter(this, vocaDataList);
                vocaRecyclerView.setLayoutManager(new LinearLayoutManager(this));
                vocaRecyclerView.setAdapter(vocaAdapter);
        }
        //endregion
        
        void searchVoca(String q) {
                List<VocabularyModel> searchResultList = new ArrayList<>();
                for (VocabularyModel voca : VocabularyDataSource.vocabularyModelList){
                        if (voca.vocabTitle.contains(q)){
                                searchResultList.add(voca);
                        }
                }
                
                vocaAdapter.updateData(searchResultList);
        }
}
