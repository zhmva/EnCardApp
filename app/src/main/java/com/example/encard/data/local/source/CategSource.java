package com.example.encard.data.local.source;

import androidx.lifecycle.LiveData;

import com.example.encard.data.model.entity.CategoryEntity;

import java.util.List;

public interface CategSource {
    void addCreate(CategoryEntity category);

    void deleteCreate(CategoryEntity category);

    LiveData<List<CategoryEntity>> getAllList();
}
