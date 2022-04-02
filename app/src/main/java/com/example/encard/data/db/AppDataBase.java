package com.example.encard.data.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.encard.data.local.Dao.CategoryDao;
import com.example.encard.data.local.Dao.WordDao;
import com.example.encard.data.model.entity.CategoryEntity;
import com.example.encard.data.model.entity.WordEntity;

@Database(entities = {CategoryEntity.class, WordEntity.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract CategoryDao categoryDao();
    public abstract WordDao wordDao();
}
