package com.example.encard.data.network;

import com.example.encard.data.model.entity.PixabayResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ImageApi {
    @GET("api/")
    Call<PixabayResponse> getImagePage(@Query("key") String key,
                                       @Query("q") String word
            , @Query("page") int page , @Query("per_page") int limit);
}
