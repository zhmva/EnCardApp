package com.example.encard.data.model;

import androidx.room.Entity;

@Entity
public class CategoryModel {
    int id;
    String category;

    public CategoryModel(int id, String category) {
        this.id = id;
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
