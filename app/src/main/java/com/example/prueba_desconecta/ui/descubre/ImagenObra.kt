package com.example.prueba_desconecta.ui.descubre

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.prueba_desconecta.R
import com.example.prueba_desconecta.io.Constantes
import com.example.prueba_desconecta.repository.MediaObraRepository
import com.example.prueba_desconecta.ui.Mood
import com.example.prueba_desconecta.viewmodel.ViewModelMedIaObraFactory
import com.example.prueba_desconecta.viewmodel.ViewModelMediaObra
import kotlinx.android.synthetic.main.activity_imagen_obra.*
import java.net.URL

class ImagenObra : AppCompatActivity() {

    private lateinit var viewModelMedia: ViewModelMediaObra
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imagen_obra)

        var imagennoDisponible = R.drawable.notavailablees
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
            if(response.isSuccessful){


                    if(response.body()?.ans?.isEmpty()!!){

                        imageView.setImageResource(imagennoDisponible)



                    }else{

                        Constantes.IMAGE_URL = response.body()?.ans!![0]?.filePath
                        val url: URL = URL(Constantes.BASE_URL + Constantes.IMAGE_URL)
                        val bitmap =
                            BitmapFactory.decodeStream(url.openConnection().getInputStream())
                        imageView.setImageBitmap(bitmap)


                }
                } else{
                Log.d("Response", response.errorBody().toString())


            }
        })










        botonimagen.setOnClickListener{
            val r = Intent(this, Mood::class.java)
            startActivity(r)
        }

    }
}