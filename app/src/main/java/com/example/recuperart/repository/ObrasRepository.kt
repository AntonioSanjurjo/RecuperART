package com.example.recuperart.repository

import com.example.recuperart.io.RetrofitInstance
import com.example.recuperart.io.response.ObrasByMuseuResponse
import retrofit2.Response

class ObrasRepository {

    suspend fun getObresByMuseu(number: Int): Response<ObrasByMuseuResponse> {
        val api = RetrofitInstance.api
        return api.getObresByMuseu(number)
    }
}
