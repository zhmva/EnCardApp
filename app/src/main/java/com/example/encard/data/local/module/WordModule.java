package com.example.encard.data.local.module;

import androidx.annotation.NonNull;

import com.example.encard.data.db.AppDataBase;
import com.example.encard.data.local.Dao.WordDao;
import com.example.encard.data.local.temp.WordTemp;
import com.example.encard.data.model.resp.WordStorage;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module(includes = {AppModule.class})
@InstallIn({SingletonComponent.class})
public class WordModule {
    @Provides
    public WordDao wordDao(@NonNull AppDataBase appDataBase) {
        return appDataBase.wordDao();
    }

    @Provides
    public WordStorage wordStorage(WordTemp wordTemp) {
        return new WordStorage(wordTemp);
    }

    @Provides
    public WordTemp wordTemp(WordDao wordDao) {
        return new WordTemp(wordDao);
    }
}

