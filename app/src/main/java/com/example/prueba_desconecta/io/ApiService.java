package com.example.prueba_desconecta.io;

import com.example.prueba_desconecta.io.response.AllMuseusResponse;
import com.example.prueba_desconecta.io.response.AllObresResponse;
import com.example.prueba_desconecta.io.response.AllTipusMuseuResponse;
import com.example.prueba_desconecta.io.response.AllTipusObraResponse;
import com.example.prueba_desconecta.io.response.MuseuByIdResponse;
import com.example.prueba_desconecta.io.response.MuseuNamesResponse;
import com.example.prueba_desconecta.io.response.ObresByMuseuResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    //int id = 0;

    @GET("getAllMuseus/")
    Call<AllMuseusResponse> getAllMuseus();

    @GET("getAllMuseusNames/")
    Call<MuseuNamesResponse> getMuseusNames();

    @GET("getAllObres/")
    Call<AllObresResponse> getAllObres();

    @GET("getAllTipusObra/")
    Call<AllTipusObraResponse> getAllTipusObra();

    @GET("getAllTipusMuseu//")
    Call<AllTipusMuseuResponse> getAllTipusMuseu();

    //@GET("getObresByMuseu/{"+this.id+"}/")
    //Call<ObresByMuseuResponse> getObresByMuseu();

    @GET(" getAllMuseusNames/")
    Call<MuseuNamesResponse> getAllMuseusNames();

    //@GET(" getMuseuById/" +this.id+"/")
    //Call<MuseuByIdResponse> getMuseuById();

}

