package com.example.prueba_desconecta.io

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient (id: String){

    private val apiService: ApiService;
    private val retrofit: Retrofit
    var apiServiceInterceptor: ApiServiceInterceptor? = null

    companion object {

        var instance: ApiClient? = null
            get() {
                if (field == null) {
                    instance = ApiClient.instance
                }
                return instance
            }

    }
    init {


        //incluir el interceptro que hemos definido

        val okhttpClientBuilder = OkHttpClient.Builder()
        okhttpClientBuilder.addInterceptor(ApiServiceInterceptor())

        val cliente =okhttpClientBuilder.build()

        // Construir el cliente de Retrofit
        retrofit = Retrofit.Builder()
            .baseUrl(Constantes.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(cliente)
            .build()

        //Instanciamos el servicio de retrofit a partir del objeto retrofit
        apiService =retrofit.create(ApiService::class.java)


    }


    fun getApiService() = apiService
    


}
