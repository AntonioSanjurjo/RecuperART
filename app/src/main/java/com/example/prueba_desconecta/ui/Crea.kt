package com.example.prueba_desconecta.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.prueba_desconecta.R
import com.example.prueba_desconecta.io.response.AllMuseusResponse
import com.example.prueba_desconecta.io.ApiAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Crea : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crea)
        //val resp : TextView = findViewById(R.id.httpResp)

        val btn: Button = findViewById(R.id.buttonCrea)
        btn.setOnClickListener{
            val r = Intent(this, Revisita::class.java)
            startActivity(r)
        }

    }

}