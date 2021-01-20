package com.example.recuperart.io;

import com.example.recuperart.io.response.AllMuseusResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("api/getAllMuseus/")
    Call<AllMuseusResponse> getAllMuseus();


}

