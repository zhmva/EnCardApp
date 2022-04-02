package com.example.encard.repository;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.encard.App;
import com.example.encard.data.common.Resource;
import com.example.encard.data.model.entity.Hit;
import com.example.encard.data.model.entity.PixabayResponse;
import com.example.encard.data.network.PixabayApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepository {
    private PixabayApi api;

    public MainRepository(PixabayApi api) {
        this.api = api;
    }

    public LiveData<Resource<PixabayResponse>> getImageLiveData(String keyWord){
        MutableLiveData<Hit> mutableLiveData = new MutableLiveData<>();
        App.pixabayApi.getImages(keyWord).enqueue(new Callback<PixabayResponse>() {
            @Override
            public void onResponse(Call<PixabayResponse> call, @NonNull Response<PixabayResponse>
                    response) {
                if (response.isSuccessful() && response.body() != null){
                    mutableLiveData.postValue((Hit) response.body().getHits());
                    }
                }

            @Override
            public void onFailure(Call<PixabayResponse> call, Throwable t) {
                Log.e("crush", t.getMessage());
            }
        });
        return mutableLiveData;
    }
}
