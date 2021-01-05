package com.example.prueba_desconecta.ui.Desconnecta_activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_desconecta.*
import com.airbnb.lottie.LottieAnimationView
import com.example.prueba_desconecta.R

class Desconecta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_desconecta)

        val btn: Button = findViewById(R.id.buttonDesconecta)
        btn.setOnClickListener{
            val r = Intent(this, Respiracio::class.java)
            startActivity(r)
        }
    }
}