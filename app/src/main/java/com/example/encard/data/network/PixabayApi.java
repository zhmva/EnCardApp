package com.example.encard.data.network;

import com.example.encard.data.model.entity.PixabayResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PixabayApi {

    @GET ("/api/?key=26046812-3bfdcc5238f10852b4cea8a0b")
    Call<PixabayResponse> getImages (@Query("q") String keyword);
}
