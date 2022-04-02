package com.example.encard.data.local.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.encard.data.model.entity.CategoryEntity;

import java.util.List;

@Dao
public interface CategoryDao {
    @Insert
    void insert(CategoryEntity category);

    @Delete
    void delete(CategoryEntity category);

    @Query("SELECT * FROM CategoryEntity")
    LiveData<List<CategoryEntity>> getAllList();
}
