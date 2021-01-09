package com.example.prueba_desconecta.io;

import com.example.prueba_desconecta.io.response.AllMuseusResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("api/getAllMuseus/")
    Call<AllMuseusResponse> getAllMuseus();


}

