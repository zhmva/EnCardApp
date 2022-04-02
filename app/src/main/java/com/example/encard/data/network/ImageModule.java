package com.example.encard.data.network;

import androidx.annotation.NonNull;

import com.example.encard.data.model.resp.Storage;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class ImageModule {
    @Provides
    @Singleton
    public ImageApi imageApi(@NonNull Retrofit retrofit) {
        return retrofit.create(ImageApi.class);
    }

    @Provides
    public Storage imageStorage(ImageApi imageApi) {
        return new Storage(imageApi);
    }

    @Provides
    @Singleton
    public Retrofit retrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl( "https://pixabay.com/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public OkHttpClient okHttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();
    }
}

