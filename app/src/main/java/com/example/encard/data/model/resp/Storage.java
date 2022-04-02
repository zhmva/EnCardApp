package com.example.encard.data.model.resp;

import androidx.annotation.NonNull;

import com.example.encard.data.local.temp.CategTemp;
import com.example.encard.data.model.entity.PixabayResponse;
import com.example.encard.data.network.ImageApi;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Storage {

    public ImageApi imageApi;

    @Inject
    public Storage(ImageApi imageApi) {
        this.imageApi = imageApi;
    }

    public Storage(CategTemp categoryTemp) {

    }

    public void getImageGyId(String word, int page, Result result) {
        imageApi.getImagePage("key", word, page, 10)
                .enqueue(new Callback<PixabayResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<PixabayResponse> call,
                                           @NonNull Response<PixabayResponse> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            result.onSuccess(response.body());
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<PixabayResponse> call, @NonNull Throwable t) {
                        result.onFailure(t);
                    }
                });
    }

    public interface Result {
        void onSuccess(PixabayResponse pixaBayResponse);

        void onFailure(Throwable throwable);
    }
}
