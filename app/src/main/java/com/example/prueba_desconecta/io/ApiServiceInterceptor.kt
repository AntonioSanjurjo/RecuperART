package com.example.prueba_desconecta.io

import okhttp3.Interceptor
import okhttp3.Response

class ApiServiceInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val urlWithParams = chain.request()
            .url
            .newBuilder()
            .addQueryParameter("", Constantes.QR_ID)
            .build()

        var request = chain.request()


        request= request?.newBuilder()
            .url(urlWithParams)
            .addHeader("Content-Type","application/json")
            .addHeader("Accept","application/json")
            .build()

        return chain.proceed(request)

    }
}
