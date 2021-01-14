package com.example.prueba_desconecta.repository

import com.example.prueba_desconecta.io.RetrofitInstance
import com.example.prueba_desconecta.io.response.MediaMuseuByMuseuResponse
import com.example.prueba_desconecta.io.response.MediaObraByObraResponse
import retrofit2.Response

class MediaObraRepository {
    suspend fun getObraMedia(number: Int): Response<MediaObraByObraResponse> {
        val api = RetrofitInstance.api
        return api.getMediaObraByObra(number)
    }
}