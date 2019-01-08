package com.softmarshmallow.seoulhighschool.Models.WordDictionary;


public class VocabularyModel
{
        public String vocabTitle;
        public String vocabDescription;
        
        public VocabularyModel setVocabTitle(String vocabTitle) {
                this.vocabTitle = vocabTitle;
                return this;
        }
        
        public VocabularyModel setVocabDescription(String vocabDescription) {
                this.vocabDescription = vocabDescription;
                return this;
        }
        
}
