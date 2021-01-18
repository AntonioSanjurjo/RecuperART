package com.example.prueba_desconecta.ui.descubre

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.prueba_desconecta.R
import com.example.prueba_desconecta.data.ExperienceData
import com.example.prueba_desconecta.io.Constantes
import com.example.prueba_desconecta.repository.MuseuContentDBRepository
import com.example.prueba_desconecta.ui.Desconnecta_activity.Desconecta
import com.example.prueba_desconecta.ui.Mood
import com.example.prueba_desconecta.ui.experience.VisitasPasadas
import com.example.prueba_desconecta.viewmodel.ViewModelFactory
import com.example.prueba_desconecta.viewmodel.ViewModelPrueba
import kotlinx.android.synthetic.main.activity_descubre.*
import kotlinx.android.synthetic.main.activity_main.nav_view

class Descubre : AppCompatActivity() {

    private lateinit var viewModel: ViewModelPrueba
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_descubre)

        val repository = MuseuContentDBRepository()
        val viewModelFactory = ViewModelFactory(repository)
        viewModel= ViewModelProvider(this, viewModelFactory).get(ViewModelPrueba:: class.java)

        viewModel.getMuseuContentById(Constantes.ID.toInt())
        viewModel.myResponse.observe(this, Observer { response ->
            if (response.isSuccessful) {
                val museo_nom: TextView = findViewById(R.id.museo_descubreix)
                museo_nom.setText(response.body()?.ans?.nom.toString())
                ExperienceData.nom_museo = response.body()?.ans?.nom.toString()
            }else{
                Log.d("Response", response.errorBody().toString())
            }
        })

        if(Constantes.ID == "0"){
            val a = Intent(this, Mood::class.java)
            startActivity(a)
        }

        //Drawer Action Bar code
        toggle = ActionBarDrawerToggle(this, drawer_descubre, R.string.open, R.string.close)
        drawer_descubre.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        nav_view.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.Experience -> {
                    startActivity(Intent(this, VisitasPasadas::class.java))
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