package com.example.recuperart.repository

import com.example.recuperart.io.RetrofitInstance
import com.example.recuperart.io.response.MediaMuseuByMuseuResponse
import retrofit2.Response

class MediaMuseuRepository {
    suspend fun getMuseuMedia(number: Int): Response<MediaMuseuByMuseuResponse> {
        val api = RetrofitInstance.api
        return api.getMediaMuseuByMuseu(number)
    }
}
