package com.example.prueba_desconecta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Escribe : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_escribe)

        val btn: Button = findViewById(R.id.buttonEscriu)
        btn.setOnClickListener{
            val r = Intent(this, Crea::class.java)
            startActivity(r)
        }
    }
}