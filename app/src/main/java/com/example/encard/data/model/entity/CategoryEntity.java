package com.example.encard.data.model.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CategoryEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String category;

    public CategoryEntity(String category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

