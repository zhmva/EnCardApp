package com.example.encard.data.model.resp;

import androidx.lifecycle.LiveData;

import com.example.encard.data.local.source.CategSource;
import com.example.encard.data.model.entity.CategoryEntity;

import java.util.List;

import javax.inject.Inject;

public class CategoryStorage {
    public final CategSource categorySource;

    @Inject
    public CategoryStorage(CategSource categorySource) {
        this.categorySource = categorySource;
    }

    public void createCategory(String word) {
        categorySource.addCreate(new CategoryEntity(word));
    }
    public void deleteCategory(CategoryEntity category){
        categorySource.deleteCreate(category);
    }

    public LiveData<List<CategoryEntity>> getCategory() {
        return categorySource.getAllList();
    }
}
