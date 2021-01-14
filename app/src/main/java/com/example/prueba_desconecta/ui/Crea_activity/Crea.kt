package com.example.prueba_desconecta.ui.Crea_activity

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.AdapterView.OnItemClickListener
import android.widget.Button
import android.widget.GridView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.example.prueba_desconecta.R
import com.example.prueba_desconecta.ui.Revisita
import kotlinx.android.synthetic.main.activity_crea.*
import java.io.IOException


@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class Crea : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crea)

        val am = assets
        try {
            val files = am.list("img")
            val grid : GridView = findViewById(R.id.grid)
            grid.adapter = ImageAdapter(this)
            grid.onItemClickListener =
                OnItemClickListener { adapterView, view, i, l ->
                    val intent = Intent(applicationContext, Puzzle::class.java)
                    intent.putExtra("assetName", files[i % files.size])
                    startActivity(intent)
                }
        } catch (e: IOException) {
            Toast.makeText(this, e.localizedMessage, Toast.LENGTH_SHORT)
        }

        val btn: Button = findViewById(R.id.buttonCrea)
        btn.setOnClickListener {
            val r = Intent(this, Revisita::class.java)
            startActivity(r)
        }
        //Drawer Action Bar code
        toggle = ActionBarDrawerToggle(this, drawer_create, R.string.open, R.string.close)
        drawer_create.addDrawerListener(toggle)
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

        /*val btnres: Button = findViewById(R.id.requestButton)
        btnres.setOnClickListener {
            var call = (ApiAdapter.getApiService()?.allMuseus)?.also {
                it.enqueue(this)
            }
        }

    }

    override fun onResponse(call: Call<AllMuseusResponse>, response: Response<AllMuseusResponse>) {
        if (response.isSuccessful()){
            var allMuseus: AllMuseusResponse? = response.body()
            var museo = allMuseus?.museos
        }
    }

    override fun onFailure(call: Call<AllMuseusResponse>, t: Throwable) {

    }*/
}