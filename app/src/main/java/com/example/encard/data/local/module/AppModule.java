package com.example.encard.data.local.module;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.room.Room;

import com.example.encard.data.db.AppDataBase;
import com.example.encard.data.local.Prefs;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {
    @Provides
    @Singleton
    public SharedPreferences sharedPreferences(@NonNull @ApplicationContext Context context) {
        return context.getSharedPreferences("Aboba",
                Context.MODE_PRIVATE);
    }

    @Provides
    public Prefs prefs(SharedPreferences sharedPreferences) {
        return new Prefs(sharedPreferences);
    }

    @Provides
    @Singleton
    public AppDataBase appDataBase(@ApplicationContext Context context) {
        AppDataBase build = Room
                .databaseBuilder(context, AppDataBase.class, "Room").
                allowMainThreadQueries()
                .build(); return build;
    }


}

