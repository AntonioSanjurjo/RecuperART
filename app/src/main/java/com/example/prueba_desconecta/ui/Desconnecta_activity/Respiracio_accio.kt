package com.example.prueba_desconecta.ui.Desconnecta_activity

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.example.prueba_desconecta.R
import com.example.prueba_desconecta.ui.Concentra_activity.Concentra
import com.example.prueba_desconecta.ui.experience.VisitasPasadas
import kotlinx.android.synthetic.main.activity_respiracio_accio.*


class Respiracio_accio : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_respiracio_accio)
        var respira: LottieAnimationView = findViewById(R.id.respiracioImageView)
        respira.frame
        respira.pauseAnimation()
        respira.setOnClickListener {
            respiraAnimation(respira, R.raw.breathi)
        }

        val btn: Button = findViewById(R.id.buttonRespiracioAccio)
        btn.setOnClickListener {
            respira.cancelAnimation()
            val r = Intent(this, Concentra::class.java)
            startActivity(r)
        }
        //Drawer Action Bar code
        toggle = ActionBarDrawerToggle(this, drawer_breath_action, R.string.open, R.string.close)
        drawer_breath_action.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        nav_view_breath_action.setNavigationItemSelectedListener {
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

    private fun respiraAnimation(imageView: LottieAnimationView, animation: Int) : Boolean {
        imageView.setAnimation(animation)
        imageView.playAnimation()
        return true
    }
}