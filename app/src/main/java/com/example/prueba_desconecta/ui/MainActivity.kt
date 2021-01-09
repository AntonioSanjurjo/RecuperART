package com.example.prueba_desconecta.ui


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.prueba_desconecta.R
import com.example.prueba_desconecta.io.Constantes
import com.example.prueba_desconecta.repository.MuseuContentDBRepository
import com.example.prueba_desconecta.ui.ui.elije.Elige
import com.example.prueba_desconecta.viewmodel.ViewModelFactory
import com.example.prueba_desconecta.viewmodel.ViewModelPrueba
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ViewModelPrueba

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = MuseuContentDBRepository()
        val viewModelFactory = ViewModelFactory(repository)
        viewModel= ViewModelProvider(this, viewModelFactory).get(ViewModelPrueba:: class.java)

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