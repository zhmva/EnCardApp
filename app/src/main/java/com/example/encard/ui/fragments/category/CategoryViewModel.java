package com.example.encard.ui.fragments.category;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.encard.R;
import com.example.encard.data.model.entity.CategoryEntity;
import com.example.encard.data.model.resp.CategoryStorage;
import com.example.encard.data.model.resp.Storage;
import com.example.encard.data.model.resp.WordStorage;

import java.util.List;

import javax.inject.Inject;

public class CategoryViewModel extends ViewModel {

    public CategoryStorage categoryStorage;
    public WordStorage wordStorage;

    @Inject
    public CategoryViewModel(CategoryStorage categoryStorage, WordStorage wordStorage) {
        this.wordStorage = wordStorage;
        this.categoryStorage = categoryStorage;
    }

    public void createCategory(String word) {
        categoryStorage.createCategory(word);
    }

    public void deleteCategory(CategoryEntity category) {
        categoryStorage.deleteCategory(category);
        wordStorage.deleteWords(wordStorage.getWordsToTag(category.getCategory()));
    }

    public LiveData<List<CategoryEntity>> getList() {
        return categoryStorage.getCategory();
    }


}
