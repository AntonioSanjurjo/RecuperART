package com.example.prueba_desconecta.ui.Desconnecta_activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.example.prueba_desconecta.R
import com.example.prueba_desconecta.ui.Concentra_activity.Concentra


class Respiracio_accio : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_respiracio_accio)
        var respira: LottieAnimationView = findViewById(R.id.respiracioImageView)
        respira.frame
        respira.pauseAnimation()
        respira.setOnClickListener {
            respiraAnimation(respira, R.raw.breathi)
        }

        val btn: Button = findViewById(R.id.buttonRespiracioAccio)
        btn.setOnClickListener{
            respira.cancelAnimation()
            val r = Intent(this, Concentra::class.java)
            startActivity(r)
        }
    }

    private fun respiraAnimation(imageView: LottieAnimationView, animation: Int) : Boolean {
        imageView.setAnimation(animation)
        imageView.playAnimation()
        return true
    }
}