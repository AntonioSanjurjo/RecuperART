package com.example.prueba_desconecta.ui.Associa_activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.prueba_desconecta.R
import com.example.prueba_desconecta.ui.Dibuja

class Asocia : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asocia)

        var list : String = "Llista de cançons:"
        var listView : TextView = findViewById(R.id.associates_list)
        var song: TextView = findViewById(R.id.associates_song)

        val btnPlay: Button = findViewById(R.id.buttonSpotify)
        btnPlay.setOnClickListener{
            val r = Intent(this, BackgroundSoundService::class.java)
            startActivity(r)
        }

        val btnNext: Button = findViewById(R.id.buttonAsocia)
        btnNext.setOnClickListener{
            val r = Intent(this, Dibuja::class.java)
            startActivity(r)
        }

        val btnAddToList : Button = findViewById(R.id.buttonAddToList)
        btnAddToList.setOnClickListener{
            list = list + "\n" + song.text.toString()
            listView.setText(list)
            song.setText(null)
        }
    }

    fun playBackgroundSound(view: View?) {
        val intent = Intent(this@Asocia, BackgroundSoundService::class.java)
        startService(intent)
    }
}