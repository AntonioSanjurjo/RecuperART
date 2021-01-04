package com.example.prueba_desconecta.io;

import com.example.prueba_desconecta.io.response.AllMediaMuseusResponse;
import com.example.prueba_desconecta.io.response.AllMediaObraResponse;
import com.example.prueba_desconecta.io.response.AllMuseusResponse;
import com.example.prueba_desconecta.io.response.AllObresResponse;
import com.example.prueba_desconecta.io.response.AllTipusMuseuResponse;
import com.example.prueba_desconecta.io.response.AllTipusObraResponse;
import com.example.prueba_desconecta.io.response.MediaMuseuResponse;
import com.example.prueba_desconecta.io.response.MediaObraResponse;
import com.example.prueba_desconecta.io.response.MuseuByIdResponse;
import com.example.prueba_desconecta.io.response.MuseuContentByIdResponse;
import com.example.prueba_desconecta.io.response.MuseuNamesResponse;
import com.example.prueba_desconecta.io.response.ObresByMuseuResponse;
import com.example.prueba_desconecta.io.response.WordCloud;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @GET("api/getAllMuseus/")
    Call<AllMuseusResponse> getAllMuseus();

    @GET("api/getAllMuseusNames/")
    Call<MuseuNamesResponse> getMuseusNames();

    @GET("api/getAllObres/")
    Call<AllObresResponse> getAllObres();

    @GET("api/getAllTipusObra/")
    Call<AllTipusObraResponse> getAllTipusObra();

    @GET("api/getAllTipusMuseu//")
    Call<AllTipusMuseuResponse> getAllTipusMuseu();

    @GET("api/getObresByMuseu/")
    Call<ObresByMuseuResponse> getObresByMuseu();

    @GET("api/getAllMuseusNames/")
    Call<MuseuNamesResponse> getAllMuseusNames();

    @GET("api/getMuseuById/")
    Call<MuseuByIdResponse> getMuseuById();

    @GET("api/getMuseuContentById/")
    Call<MuseuContentByIdResponse> getMuseuContentById();

    @GET("api/getAllMediaMuseu/")
    Call<AllMediaMuseusResponse> getAllMediaMuseu();

    @GET("api/getMediaMuseuByMuseu/")
    Call<MediaMuseuResponse> getMediaMuseu();

    @GET("api/getMediaMuseuByCategoria/")
    Call<MediaMuseuResponse> getMediaMuseuByCategoria();

    @GET("api/getAllMediaObra/")
    Call<AllMediaObraResponse> getAllMediaObra();

    @GET("api/getMediaObraByObra/")
    Call<MediaObraResponse> getMediaObra();

    @GET("api/getMediaObraByFiletype/")
    Call<MediaObraResponse> getMediaObraByFileType();

    @GET("api/getMediaObraByCategoria/")
    Call<MediaObraResponse> getMediaObraByCategoria();

    @POST("WordCloud/getWordCloud")
    Call<WordCloud> postWordCloud(@Body RequestBody body);

}

