package com.softmarshmallow.seoulhighschool.Views.DictionarySearch;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.softmarshmallow.seoulhighschool.Models.AcademicScheduleModel;
import com.softmarshmallow.seoulhighschool.Models.WordDictionary.VocabularyModel;
import com.softmarshmallow.seoulhighschool.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.functions.Consumer;


public class VocaCardViewHolder extends RecyclerView.ViewHolder
{
        @BindView(R.id.vocaTitleTextView)
        TextView vocaTitleText;

        @BindView(R.id.vocaDescriptionTextView)
        TextView vocaDescriptionText;
        

        private Context context;
        private VocabularyModel scheduleData;


        public VocaCardViewHolder(View itemView, final Context context, final Consumer<VocabularyModel> onclick) {
                super(itemView);
                ButterKnife.bind(this, itemView);
                this.context = context;
                itemView.setOnClickListener(new View.OnClickListener()
                {
                        @Override
                        public void onClick(View view) {
                                try {
                                        onclick.accept(scheduleData);
                                }
                                catch (Exception e) {
                                        e.printStackTrace();
                                }
                        }
                });
        }

        public void BindViewWithData(VocabularyModel vocabularyModel) {
                this.scheduleData = vocabularyModel;
                vocaTitleText.setText(vocabularyModel.vocabTitle);
                vocaDescriptionText.setText(vocabularyModel.vocabDescription);
        }
}
