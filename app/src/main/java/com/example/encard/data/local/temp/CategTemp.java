package com.example.encard.data.local.temp;

import androidx.lifecycle.LiveData;

import com.example.encard.data.local.Dao.CategoryDao;
import com.example.encard.data.local.source.CategSource;
import com.example.encard.data.model.entity.CategoryEntity;

import java.util.List;

import javax.inject.Inject;

public class CategTemp implements CategSource {
    private final CategoryDao categoryDao;

    @Inject
    public CategTemp(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public void addCreate(CategoryEntity category) {

    }

    @Override
    public void deleteCreate(CategoryEntity category) {

    }

    @Override
    public LiveData<List<CategoryEntity>> getAllList() {
        return null;
    }
}
