package com.example.prueba_desconecta.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.prueba_desconecta.R
import kotlin.system.exitProcess

class Revisita : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_revisita)

        val btn: Button = findViewById(R.id.buttonEnd)
        btn.setOnClickListener{
            Toast.makeText(this,"Heu acabat",Toast.LENGTH_SHORT).show()
            this.finish()
            exitProcess(0)
        }
    }
}