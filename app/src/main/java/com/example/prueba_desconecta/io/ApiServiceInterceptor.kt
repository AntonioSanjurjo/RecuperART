package com.example.prueba_desconecta.io

import android.os.Parcel
import android.os.Parcelable
import okhttp3.Interceptor
import okhttp3.Response

class ApiServiceInterceptor(id:String) : Interceptor{

    var id: String= "";

    init {
        this.id=id
    }


    override fun intercept(chain: Interceptor.Chain): Response {
        TODO("Not yet implemented")

        val urlWithParams = chain.request()
            .url
            .newBuilder()
            .addQueryParameter("id",id)
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