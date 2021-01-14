package com.example.prueba_desconecta.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.prueba_desconecta.R
import com.example.prueba_desconecta.ui.Crea_activity.Crea
import kotlinx.android.synthetic.main.activity_escribe.*

class Escribe : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_escribe)

        val btn: Button = findViewById(R.id.buttonEscriu)
        btn.setOnClickListener{
            val r = Intent(this, Crea::class.java)
            startActivity(r)
        }
        //Drawer Action Bar code
        toggle = ActionBarDrawerToggle(this, drawer_write, R.string.open, R.string.close)
        drawer_write.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        nav_view_write.setNavigationItemSelectedListener {
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