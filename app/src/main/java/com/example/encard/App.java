package com.example.encard;

import android.app.Application;

import androidx.room.Room;

import com.example.encard.data.network.PixabayApi;
import com.example.encard.data.network.RetrofitClient;
import com.example.encard.repository.MainRepository;

public class App extends Application {
    public static RetrofitClient retrofitClient;
    public static PixabayApi api;
    public static MainRepository repository;
    public static PixabayApi pixabayApi;

    @Override
    public void onCreate() {
        super.onCreate();
        retrofitClient = new RetrofitClient();
        api = retrofitClient.getApi();
        repository = new MainRepository(api);
    }
}
