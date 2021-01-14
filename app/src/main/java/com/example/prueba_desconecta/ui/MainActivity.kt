package com.example.prueba_desconecta.ui


import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.prueba_desconecta.R
import com.example.prueba_desconecta.io.Constantes
import com.example.prueba_desconecta.repository.MediaObraRepository
import com.example.prueba_desconecta.repository.MuseuContentDBRepository
import com.example.prueba_desconecta.repository.ObrasRepository
import com.example.prueba_desconecta.ui.ui.elije.Elige
import com.example.prueba_desconecta.viewmodel.*
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URL


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ViewModelPrueba
    private lateinit var viewModelobras: ViewModelObras
    private lateinit var viewModelMediaObra: ViewModelMediaObra

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val policy =

            ////Evitar error NetworkOnMainThreadException
            StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        val repository = MuseuContentDBRepository()
        val repositoryobras =ObrasRepository()
        val repositoryMediaObra = MediaObraRepository()

        val viewModelFactory = ViewModelFactory(repository)
        val viewModelFactoryobras = ViewModelFactoryObras(repositoryobras)
        val viewModelMediaObraFactory = ViewModelMedIaObraFactory(repositoryMediaObra)

        viewModel= ViewModelProvider(this, viewModelFactory).get(ViewModelPrueba:: class.java)
        viewModelobras = ViewModelProvider(this, viewModelFactoryobras).get(ViewModelObras::class.java)
        viewModelMediaObra = ViewModelProvider(this, viewModelMediaObraFactory).get(ViewModelMediaObra::class.java)

        val get: Button = findViewById((R.id.get))
        get.setOnClickListener {
        viewModel.getMuseuContentById(Constantes.PRUEBA_ID)
        viewModel.myResponse.observe(this, Observer { response ->
            if (response.isSuccessful) {

                Log.d("Response", response.body()?.err.toString())
                Log.d("Response", response.body()?.status.toString())
                Log.d("Response", response.body()?.version.toString())
                Log.d("Response", response.body()?.ans?.descripcio.toString())
                Log.d("Response", response.body()?.ans?.id.toString())
                Log.d("Response", response.body()?.ans?.nom.toString())
                Log.d("Response", response.body()?.ans?.direccio.toString())
            }else{
                Log.d("Response", response.errorBody().toString())
            }
        })

         viewModelobras.getObras(Constantes.PRUEBA_ID)
            viewModelobras.myResponse.observe(this, Observer { response ->
                if (response.isSuccessful){
                    Log.d("Response", response.body()?.err.toString())
                    Log.d("Response", response.body()?.status.toString())
                    Log.d("Response", response.body()?.version.toString())
                    Log.d("Response", response.body()?.ans?.get(0)?.autor)
                    Log.d("Response", response.body()?.ans?.get(1)?.autor)


                }else{
                    Log.d("Response", response.errorBody().toString())


                }
            })


            viewModelMediaObra.getMediaObra(12)
            viewModelMediaObra.myResponse.observe(this, Observer { response ->
                if (response.isSuccessful){
                    Log.d("Response", response.body()?.err.toString())
                    Log.d("Response", response.body()?.status.toString())
                    Log.d("Response", response.body()?.version.toString())
                    Log.d("Response", response.body()?.ans.isNullOrEmpty().toString())

                    Constantes.IMAGE_URL= response.body()?.ans?.get(0)?.filePath.toString()



                }
            })

        }




        val image: Button = findViewById((R.id.image))
        image.setOnClickListener {

            val imageView: ImageView = findViewById(R.id.entities)
            val url: URL = URL(Constantes.BASE_URL + Constantes.IMAGE_URL)
            val bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream())
            imageView.setImageBitmap(bitmap)
        }

val btn: Button = findViewById(R.id.buttonMain)
        btn.setOnClickListener {
            val r = Intent(this, Elige::class.java)
            startActivity(r)
        }

        //Drawer Action Bar code
        toggle = ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        nav_view.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.Experience -> {
                    //(val a = Intent(this, VisitasPasadas::class.java)
                    //startActivity(a)
                }
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(toggle.onOptionsItemSelected(item)){return true}
        return super.onOptionsItemSelected(item)
    }
}
