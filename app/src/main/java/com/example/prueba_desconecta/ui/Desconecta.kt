package com.example.prueba_desconecta.ui

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

        desconectaImageView.setOnClickListener {
            inspiraAnimation(desconectaImageView, R.raw.breath)
        }

        val btn: Button = findViewById(R.id.buttonDesconecta)
        btn.setOnClickListener{
            val r = Intent(this, Concentra::class.java)
            startActivity(r)
        }
    }

    private fun inspiraAnimation(imageView: LottieAnimationView, animation: Int) : Boolean {
        imageView.setAnimation(animation)
        imageView.playAnimation()
        return true
    }
}