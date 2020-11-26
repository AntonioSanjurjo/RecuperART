package com.example.prueba_desconecta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button

class Dibuja : AppCompatActivity() {

    val REQUEST_IMAGE_CAPTURE = 1



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dibuja)

        val btn: Button = findViewById(R.id.buttonDibuixa)
        btn.setOnClickListener{
            val r = Intent(this, Escribe::class.java)
            startActivity(r)
        }
    }
    private fun dispatchTakePictureIntent() {
            Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
    }
}