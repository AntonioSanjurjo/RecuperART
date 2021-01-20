package com.example.recuperart.repository

import com.example.recuperart.io.RetrofitInstance
import com.example.recuperart.io.response.MediaObraByObraResponse
import retrofit2.Response

class MediaObraRepository {
    suspend fun getObraMedia(number: Int): Response<MediaObraByObraResponse> {
        val api = RetrofitInstance.api
        return api.getMediaObraByObra(number)
    }
}