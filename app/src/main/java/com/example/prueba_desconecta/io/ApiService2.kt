package com.example.prueba_desconecta.io

import com.example.prueba_desconecta.io.response.MuseuByIdContentResponse2
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService2 {


    @GET("api/getMuseuContentById/{postNumber}")
    suspend fun getMuseuContent(
        @Path("postNumber") number: Int
    ): Response<MuseuByIdContentResponse2>

}