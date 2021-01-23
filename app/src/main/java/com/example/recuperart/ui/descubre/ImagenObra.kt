package com.example.recuperart.ui.descubre

import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.os.StrictMode
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.recuperart.R
import com.example.recuperart.io.Constantes
import com.example.recuperart.repository.MediaObraRepository
import com.example.recuperart.ui.Mood
import com.example.recuperart.viewmodel.ViewModelMedIaObraFactory
import com.example.recuperart.viewmodel.ViewModelMediaObra
import kotlinx.android.synthetic.main.activity_imagen_obra.*
import java.io.File
import java.io.FileOutputStream
import java.net.URL

class ImagenObra : AppCompatActivity() {

    private lateinit var viewModelMedia: ViewModelMediaObra
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imagen_obra)
        val imagennoDisponible = R.drawable.notavailablees
        val imageView: ImageView = findViewById(R.id.obraElegida)
        val bundle = intent.extras

        if (bundle.getString("obraNom") != null) {
            texto.text = bundle.get("obraNom") as CharSequence?
        }

        //Evitar error NetworkOnMainThreadException
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        val repository = MediaObraRepository()
        val viewModelFactory = ViewModelMedIaObraFactory(repository)
        viewModelMedia = ViewModelProvider(this, viewModelFactory).get(ViewModelMediaObra::class.java)
        viewModelMedia.getMediaObra(Constantes.ID_OBRA.toInt())
        viewModelMedia.myResponse.observe(this, Observer { response ->
            if(response.isSuccessful) {
                if (response.body()?.ans?.isEmpty()!!) {
                    imageView.setImageResource(imagennoDisponible)
                    Constantes.IMAGEN_OBRA = imageView.drawable.toBitmap()
                } else {
                    Constantes.IMAGE_URL = response.body()?.ans!![0]?.filePath
                    val url: URL = URL(Constantes.BASE_URL + Constantes.IMAGE_URL)
                    val bitmap =
                        BitmapFactory.decodeStream(url.openConnection().getInputStream())
                    imageView.setImageBitmap(bitmap)
                    Constantes.IMAGEN_OBRA = bitmap
                }
            }
        })

        botonimagen.setOnClickListener{
            val r = Intent(this, Mood::class.java)
            startActivity(r)
        }
    }
}