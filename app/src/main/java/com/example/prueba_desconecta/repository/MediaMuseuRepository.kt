package com.example.prueba_desconecta.repository

import com.example.prueba_desconecta.io.RetrofitInstance
import com.example.prueba_desconecta.io.response.MediaMuseuByMuseuResponse
import com.example.prueba_desconecta.io.response.MuseuByIdContentResponse2
import retrofit2.Response

class MediaMuseuRepository {
    suspend fun getMuseuMedia(number: Int): Response<MediaMuseuByMuseuResponse> {
        val api = RetrofitInstance.api
        return api.getMediaMuseuByMuseu(number)
    }
}
