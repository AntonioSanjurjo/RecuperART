package com.example.recuperart.io

import com.example.recuperart.io.response.MediaMuseuByMuseuResponse
import com.example.recuperart.io.response.MediaObraByObraResponse
import com.example.recuperart.io.response.MuseuByIdContentResponse
import com.example.recuperart.io.response.ObrasByMuseuResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService2 {


    @GET("api/getMuseuContentById/{postNumber}")
    suspend fun getMuseuContent(
        @Path("postNumber") number: Int
    ): Response<MuseuByIdContentResponse>

    @GET("api/getMediaMuseuByMuseu/{postNumber}")
    suspend fun getMediaMuseuByMuseu(
        @Path("postNumber") number: Int
    ): Response<MediaMuseuByMuseuResponse>

    @GET("api/getObresByMuseu/{postNumber}")
    suspend fun getObresByMuseu(
        @Path("postNumber") number: Int
    ): Response<ObrasByMuseuResponse>

    @GET("api/getMediaObraByObra/{postNumber}")
    suspend fun getMediaObraByObra(
        @Path("postNumber") number: Int
    ): Response<MediaObraByObraResponse>



}