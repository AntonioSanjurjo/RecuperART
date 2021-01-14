package com.example.prueba_desconecta.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.prueba_desconecta.R
import com.example.prueba_desconecta.ui.Avalua_activity.FinalMood
import kotlinx.android.synthetic.main.activity_revisita.*

class Revisita : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_revisita)

        val btn: Button = findViewById(R.id.buttonEnd)
        btn.setOnClickListener{
            val r = Intent(this, FinalMood::class.java)
            //val r = Intent(this, Avalua::class.java)
            startActivity(r)
            //Toast.makeText(this,"Heu acabat",Toast.LENGTH_SHORT).show()
            //this.finish()
            //exitProcess(0)
        }
        //Drawer Action Bar code
        toggle = ActionBarDrawerToggle(this, drawer_revisit, R.string.open, R.string.close)
        drawer_revisit.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        nav_view_revisit.setNavigationItemSelectedListener {
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