package com.example.prueba_desconecta.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.prueba_desconecta.R

class Concentra : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_concentra)

        val btn: Button = findViewById(R.id.buttonConcentra)
        btn.setOnClickListener{
            val r = Intent(this, Asocia::class.java)
            startActivity(r)
        }
    }
}