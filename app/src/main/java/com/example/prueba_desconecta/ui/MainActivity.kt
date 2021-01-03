package com.example.prueba_desconecta.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.prueba_desconecta.R
import com.example.prueba_desconecta.ui.ui.elije.Elige

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn: Button = findViewById(R.id.buttonMain)
        btn.setOnClickListener{
            val r = Intent(this, Elige::class.java)
            startActivity(r)
        }
    }

}