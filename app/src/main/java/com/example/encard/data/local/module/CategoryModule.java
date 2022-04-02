package com.example.encard.data.local.module;

import androidx.annotation.NonNull;

import com.example.encard.data.db.AppDataBase;
import com.example.encard.data.local.Dao.CategoryDao;
import com.example.encard.data.local.temp.CategTemp;
import com.example.encard.data.model.resp.Storage;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;


@Module(includes = {AppModule.class})
@InstallIn(SingletonComponent.class)
public class CategoryModule {
    @Provides
    public CategoryDao categoryDao(@NonNull AppDataBase appDataBase) {
        return appDataBase.categoryDao();
    }

    @Provides
    public Storage categoryStorage(CategTemp categoryTemp) {
        return new Storage(categoryTemp);
    }

    @Provides
    public CategTemp categoryTemp(CategoryDao categoryDao) {
        return new CategTemp(categoryDao);
    }
}
