package com.example.prueba_desconecta.io.response

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiAdapter {
    private var API_SERVICE: ApiService? = null// <-- usamos el log level

    // Creamos un interceptor y le indicamos el log level a usar
    val apiService: ApiService?
        get() {

            // Creamos un interceptor y le indicamos el log level a usar
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)

            // Asociamos el interceptor a las peticiones
            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor(logging)

            val baseUrl = "http://pae-ics.etsetb.upc.edu/api/"
            if (API_SERVICE == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build()) // <-- usamos el log level
                    .build()
                API_SERVICE = retrofit.create(ApiService::class.java)
            }
            return API_SERVICE
        }
}