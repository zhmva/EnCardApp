package com.example.encard.data.local.temp;

import androidx.lifecycle.LiveData;

import com.example.encard.data.local.Dao.WordDao;
import com.example.encard.data.local.source.WordSource;
import com.example.encard.data.model.entity.WordEntity;

import java.util.List;

import javax.inject.Inject;

public class WordTemp implements WordSource {
    private final WordDao wordDao;
    @Inject
    public WordTemp(WordDao wordDao) {
        this.wordDao = wordDao;
    }


    @Override
    public void addWord(WordEntity wordEntity) {

    }

    @Override
    public void deleteWords(List<WordEntity> wordEntities) {

    }

    @Override
    public void deleteWord(WordEntity wordEntity) {

    }

    @Override
    public LiveData<List<WordEntity>> getLiveList(String category) {
        return null;
    }

    @Override
    public List<WordEntity> getList(String category) {
        return null;
    }
}
