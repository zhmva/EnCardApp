package com.example.encard.data.local;

import android.content.SharedPreferences;

import com.example.encard.keyword.KeyString;

import javax.inject.Inject;

public class Prefs {
    private final SharedPreferences preferences;

    @Inject
    public Prefs(SharedPreferences sharedPreferences) {
        this.preferences = sharedPreferences;
    }

    public void saveState() {
        preferences.edit().putBoolean(KeyString.SHOW, true).apply();
    }

    public Boolean isBoardShown() {
        return preferences.getBoolean(KeyString.SHOW, false);
    }

}
