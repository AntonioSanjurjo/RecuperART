package com.example.prueba_desconecta.repository

import com.example.prueba_desconecta.io.RetrofitInstance
import com.example.prueba_desconecta.io.response.MuseuByIdContentResponse
import retrofit2.Response

class MuseuContentDBRepository{

    suspend fun getMuseuContentById(number: Int): Response<MuseuByIdContentResponse>{
        val api = RetrofitInstance.api
        return api.getMuseuContent(number)
    }
}