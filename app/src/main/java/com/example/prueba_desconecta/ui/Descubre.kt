package com.example.prueba_desconecta.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.prueba_desconecta.R
import com.example.prueba_desconecta.io.ApiAdapter
import com.example.prueba_desconecta.io.ApiClient
import com.example.prueba_desconecta.io.ApiService
import com.example.prueba_desconecta.io.response.MuseuContentByIdResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Descubre : AppCompatActivity() {

    var apiService: ApiService? = null
    var apiClient: ApiClient? = null
    var museo: Museo? =null;



    init {
        apiClient = ApiClient.instance
        apiService = apiClient?.getApiService()
        museo = TheMuseo()

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_descubre)

        val btn: Button = findViewById(R.id.buttonDescubreix)
        btn.setOnClickListener{
            val r = Intent(this, Desconecta::class.java)
            startActivity(r)
        }
    }





    fun TheMuseo(): Museo?{

        if (museo== null){
            museo=Museo()

        }

        var call = (ApiAdapter.getApiService()?.museuContentById)?.also {
            it.enqueue( object: Callback<MuseuContentByIdResponse> {

                override fun onFailure(call: Call<MuseuContentByIdResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }

                override fun onResponse(
                    call: Call<MuseuContentByIdResponse>,
                    response: Response<MuseuContentByIdResponse>
                ) {
                    var Museu: MuseuContentByIdResponse? = response.body()
                    var museo = Museu?.museu
                }


            })
        }
        return museo
    }


}