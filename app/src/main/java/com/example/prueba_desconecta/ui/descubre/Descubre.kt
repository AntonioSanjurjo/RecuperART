package com.example.prueba_desconecta.ui.descubre

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.prueba_desconecta.R
import com.example.prueba_desconecta.io.ApiAdapter
import com.example.prueba_desconecta.io.ApiClient
import com.example.prueba_desconecta.io.ApiService
import com.example.prueba_desconecta.io.response.MuseuContentByIdResponse
import com.example.prueba_desconecta.ui.Desconecta
import com.example.prueba_desconecta.ui.Museo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Descubre : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_descubre)

        val btn: Button = findViewById(R.id.buttonDescubreix)
        btn.setOnClickListener{
            val r = Intent(this, Desconecta::class.java)
            startActivity(r)
        }
    }
}