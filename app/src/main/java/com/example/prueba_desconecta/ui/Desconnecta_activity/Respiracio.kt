package com.example.prueba_desconecta.ui.Desconnecta_activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.prueba_desconecta.R

class Respiracio : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_respiracio)

            val btn: Button = findViewById(R.id.buttonRespira)
            btn.setOnClickListener{
                val r = Intent(this, Respiracio_accio::class.java)
                startActivity(r)
            }
    }
}