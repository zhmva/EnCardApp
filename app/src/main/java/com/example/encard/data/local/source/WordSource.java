package com.example.encard.data.local.source;

import androidx.lifecycle.LiveData;

import com.example.encard.data.model.entity.WordEntity;

import java.util.List;

public interface WordSource {

    void addWord(WordEntity wordEntity);

    void deleteWords(List<WordEntity> wordEntities);

    void deleteWord(WordEntity wordEntity);

    LiveData<List<WordEntity>> getLiveList(String category);

    List<WordEntity> getList(String category);
}

