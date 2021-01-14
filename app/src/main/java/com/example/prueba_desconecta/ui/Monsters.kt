package com.example.prueba_desconecta.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.prueba_desconecta.R
import com.example.prueba_desconecta.ui.Associa_activity.Asocia
import com.example.prueba_desconecta.ui.Desconnecta_activity.Desconecta
import com.example.prueba_desconecta.ui.descubre.Descubre

class Monsters : AppCompatActivity() {
    var getThemeku: String? = null
    var themeku = ""
    var SHARED_PREFS = "codeTheme"
    var subtitlepage: TextView? = null
    var btncontinue: Button? = null
    var icontheme: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mood_monster)
        subtitlepage = findViewById(R.id.subtitlepage)
        btncontinue = findViewById(R.id.btncontinue)
        val btn : Button = findViewById(R.id.btncontinue)
        icontheme = findViewById(R.id.icontheme)

        // give an event to next activity
        btn.setOnClickListener(View.OnClickListener {
            val a = Intent(this@Monsters, Desconecta::class.java)
            startActivity(a)
        })
        changeOurTheme()
    }

    fun changeOurTheme() {
        val sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE)
        getThemeku = sharedPreferences.getString(themeku, "")
        if (getThemeku == "blue") {
            icontheme!!.setImageResource(R.drawable.icmob)
            btncontinue!!.setBackgroundResource(R.drawable.bgblue)
            subtitlepage!!.text = "L’aigua és preciosa de color blau"
        } else if (getThemeku == "green") {
            icontheme!!.setImageResource(R.drawable.icmog)
            btncontinue!!.setBackgroundResource(R.drawable.bggreen)
            subtitlepage!!.text = "La Natura i el color Verd són amics"
        } else if (getThemeku == "purple") {
            icontheme!!.setImageResource(R.drawable.icmop)
            btncontinue!!.setBackgroundResource(R.drawable.bgpurple)
            subtitlepage!!.text = "Brillant fins i tot a les fosques"
        } else if (getThemeku == "orange") {
            icontheme!!.setImageResource(R.drawable.icmoc)
            btncontinue!!.setBackgroundResource(R.drawable.bgorange)
            subtitlepage!!.text = "El taronja és com un groc"
        }
    }
}