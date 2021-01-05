package com.example.prueba_desconecta.ui.Crea_activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.prueba_desconecta.R
import com.example.prueba_desconecta.io.response.AllMuseusResponse
import com.example.prueba_desconecta.io.ApiAdapter
import com.example.prueba_desconecta.ui.Revisita
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Crea : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crea)
        //val resp : TextView = findViewById(R.id.httpResp)

        val btn: Button = findViewById(R.id.buttonCrea)
        btn.setOnClickListener {
            val r = Intent(this, Puzzle::class.java)
            startActivity(r)
        }
    }

        /*val btnres: Button = findViewById(R.id.requestButton)
        btnres.setOnClickListener {
            var call = (ApiAdapter.getApiService()?.allMuseus)?.also {
                it.enqueue(this)
            }
        }

    }

    override fun onResponse(call: Call<AllMuseusResponse>, response: Response<AllMuseusResponse>) {
        if (response.isSuccessful()){
            var allMuseus: AllMuseusResponse? = response.body()
            var museo = allMuseus?.museos
        }
    }

    override fun onFailure(call: Call<AllMuseusResponse>, t: Throwable) {

    }*/
}