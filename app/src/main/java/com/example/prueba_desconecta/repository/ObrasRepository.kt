package com.example.prueba_desconecta.repository

import com.example.prueba_desconecta.io.RetrofitInstance
import com.example.prueba_desconecta.io.response.ObrasByMuseuResponse
import retrofit2.Response

class ObrasRepository {

    suspend fun getObresByMuseu(number: Int): Response<ObrasByMuseuResponse> {
        val api = RetrofitInstance.api
        return api.getObresByMuseu(number)
    }
}
