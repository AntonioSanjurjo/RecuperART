package com.example.recuperart.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.recuperart.R
import com.example.recuperart.data.ExperienceData
import com.example.recuperart.ui.Avalua_activity.FinalMood
import com.example.recuperart.ui.experience.VisitasPasadas
import kotlinx.android.synthetic.main.activity_revisita.*

class Revisita : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_revisita)

        val revisita : EditText = findViewById(R.id.revisit_user)
        val btn: Button = findViewById(R.id.buttonEnd)
        btn.setOnClickListener{
            ExperienceData.revisita = revisita.text.toString()
            val r = Intent(this, FinalMood::class.java)
            startActivity(r)
        }
        //Drawer Action Bar code
        toggle = ActionBarDrawerToggle(this, drawer_revisit, R.string.open, R.string.close)
        drawer_revisit.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        nav_view_revisit.setNavigationItemSelectedListener {
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