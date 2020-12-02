package com.example.prueba_desconecta.io.response;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("getAllMuseus/")
    Call<ResponseAllMuseus> getAllMuseus();
}

