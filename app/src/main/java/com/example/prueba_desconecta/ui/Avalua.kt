package com.example.prueba_desconecta.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.prueba_desconecta.R

class Avalua : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avalua)

        val btn: Button = findViewById(R.id.buttonEnd)
        btn.setOnClickListener{

            //finish();
            val r = Intent(this, Avalua::class.java)
            startActivity(r)
            //this.finish()
            //exitProcess(0)
        }
    }
}