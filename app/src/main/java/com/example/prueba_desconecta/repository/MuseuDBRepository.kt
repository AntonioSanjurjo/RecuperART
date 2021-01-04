package com.example.prueba_desconecta.repository

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.prueba_desconecta.common.MyApp
import com.example.prueba_desconecta.io.ApiAdapter
import com.example.prueba_desconecta.io.ApiClient
import com.example.prueba_desconecta.io.ApiService
import com.example.prueba_desconecta.io.response.MuseuByIdResponse
import com.example.prueba_desconecta.io.response.MuseuContentByIdResponse
import com.example.prueba_desconecta.ui.Museo
import com.example.prueba_desconecta.ui.Obra
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MuseuDBRepository {
    var apiService: ApiService? =null
    var apiClient: ApiClient? =null
    var museo: Museo? = null
    var allObras : MutableLiveData<ArrayList<Obra>>? = null

    init {
        apiClient = ApiClient.instance
        apiService = apiClient?.getApiService()
        museo = TheMuseo()
    }

    fun TheMuseo(): Museo?{

        if (museo== null){
            museo= Museo()

        }

        var call = (ApiAdapter.getApiService()?.museuContentById)?.also {
            it.enqueue( object: Callback<MuseuContentByIdResponse> {

                override fun onFailure(call: Call<MuseuContentByIdResponse>, t: Throwable) {
                    Toast.makeText(MyApp.instance, "Error en la llamada", Toast.LENGTH_LONG).show()
                }

                override fun onResponse(
                    call: Call<MuseuContentByIdResponse>,
                    response: Response<MuseuContentByIdResponse>
                ){ if (response.isSuccessful()) {
                    museo = response.body()?.museu!!
                    var arrayobras = response.body()?.museu?.obras
                    allObras!!.setValue(arrayobras)
                }
                }


            })
        }
        return museo
    }
}