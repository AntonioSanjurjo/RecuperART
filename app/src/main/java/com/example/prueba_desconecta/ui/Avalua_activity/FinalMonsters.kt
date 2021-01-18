package com.example.prueba_desconecta.ui.Avalua_activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.prueba_desconecta.R
import com.example.prueba_desconecta.data.Experience
import com.example.prueba_desconecta.data.ExperienceData
import com.example.prueba_desconecta.ui.experience.VisitasPasadas
import com.example.prueba_desconecta.viewmodel.ExperienceViewModel
import kotlinx.android.synthetic.main.activity_final_monsters.*
import kotlinx.android.synthetic.main.activity_mood_monster.*
import kotlinx.android.synthetic.main.activity_revisita.*

class FinalMonsters : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    var getThemeku: String? = null
    var themeku = ""
    var SHARED_PREFS = "codeTheme"
    var subtitlepage: TextView? = null
    var btncontinue: Button? = null
    var icontheme: ImageView? = null

    private lateinit var experienceViewModel : ExperienceViewModel

    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_monsters)
        subtitlepage = findViewById(R.id.subtitlepage)
        icontheme = findViewById(R.id.icontheme)
        btncontinue = findViewById(R.id.btncontinue)

        // give an event to next activity
        btncontinue?.setOnClickListener(View.OnClickListener {
            val a = Intent(this@FinalMonsters, Avalua::class.java)
            startActivity(a)
        })
        changeOurTheme()

        //Set Experience Data to Database
        experienceViewModel = ViewModelProvider(this).get(ExperienceViewModel::class.java)
        var experience = Experience(ExperienceData.nom_museo, ExperienceData.nom_obra, ExperienceData.colorstart, ExperienceData.workcloud, ExperienceData.cancion, ExperienceData.dibujo, ExperienceData.escribe, ExperienceData.revisita, ExperienceData.colorend)
        experienceViewModel.addExperience(experience)

        //Drawer Action Bar code
        toggle = ActionBarDrawerToggle(this, drawer_final_monsters, R.string.open, R.string.close)
        drawer_final_monsters.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        nav_view_final_monsters.setNavigationItemSelectedListener {
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

    fun changeOurTheme() {
        val sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE)
        getThemeku = sharedPreferences.getString(themeku, "")
        if (getThemeku == "yellow") {
            ExperienceData.colorend= "#FDE34A"
            icontheme!!.setImageResource(R.drawable.happy)
            btncontinue!!.setBackgroundResource(R.drawable.bgblue)
            subtitlepage!!.text = "Irradies vibracions positives. La llum està amb tu"
        } else if (getThemeku == "green") {
            ExperienceData.colorend= "#1ABC9C"
            icontheme!!.setImageResource(R.drawable.sad)
            btncontinue!!.setBackgroundResource(R.drawable.bggreen)
            subtitlepage!!.text = "La Natura i el color Verd són amics"
        } else if (getThemeku == "purple") {
            ExperienceData.colorend= "#E03FA2"
            icontheme!!.setImageResource(R.drawable.fear)
            btncontinue!!.setBackgroundResource(R.drawable.bgpurple)
            subtitlepage!!.text = "Brillant fins i tot a les fosques"
        } else if (getThemeku == "red") {
            ExperienceData.colorend= "#B23B3F"
            icontheme!!.setImageResource(R.drawable.angry)
            btncontinue!!.setBackgroundResource(R.drawable.bgorange)
            subtitlepage!!.text = "El taronja és com un groc"
        }
    }
}