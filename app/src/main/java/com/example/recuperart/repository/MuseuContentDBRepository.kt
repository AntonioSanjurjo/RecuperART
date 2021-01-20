package com.example.recuperart.repository

import com.example.recuperart.io.RetrofitInstance
import com.example.recuperart.io.response.MuseuByIdContentResponse
import retrofit2.Response

class MuseuContentDBRepository{

    suspend fun getMuseuContentById(number: Int): Response<MuseuByIdContentResponse>{
        val api = RetrofitInstance.api
        return api.getMuseuContent(number)
    }
}