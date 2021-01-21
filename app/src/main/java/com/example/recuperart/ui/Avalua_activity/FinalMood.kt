package com.example.recuperart.ui.Avalua_activity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.example.recuperart.R
import com.example.recuperart.ui.experience.VisitasPasadas
import kotlinx.android.synthetic.main.activity_final_mood.*
import kotlinx.android.synthetic.main.activity_revisita.*

class FinalMood : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    private var SHARED_PREFS = "codeTheme"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_mood)
        val btngreen: Button = findViewById(R.id.btngreen)
        val btnyellow : Button = findViewById(R.id.btnyellow)
        val btnpurple : Button = findViewById(R.id.btnpurple)
        val btnred : Button = findViewById(R.id.btnred)
        val holderbg : View = findViewById(R.id.holderbg)
        val dynamicbg : View = findViewById(R.id.dynamicbg)
        // get the id
        val btnsave : Button = findViewById(R.id.btnsave)

        // give an event to next activity
        btnsave.setOnClickListener {
            val a = Intent(this@FinalMood, FinalMonsters::class.java)
            startActivity(a)
        }


        // set the first-time background
        holderbg.setBackgroundResource(R.drawable.bggreen)
        holderbg.scaleY = 3f
        holderbg.scaleX = 3f

        // set the scale of button clicked
        btngreen.scaleY = 1.5f
        btngreen.scaleX = 1.5f

        // save to local storage (default)
        val themeku = ""
        val sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(themeku, "green")
        editor.apply()

        // set function of changing theme
        btnyellow.setOnClickListener { // scale animation
            btnyellow.animate().translationY(20f).scaleX(1.5f).scaleY(1.5f).setDuration(350).start()

            // default the scale buttons
            btngreen.animate().translationY(0f).scaleX(1f).scaleY(1f).setDuration(350).start()
            btnpurple.animate().translationY(0f).scaleX(1f).scaleY(1f).setDuration(350).start()
            btnred.animate().translationY(0f).scaleX(1f).scaleY(1f).setDuration(350).start()

            // change the background
            dynamicbg.setBackgroundResource(R.drawable.bgyellow)
            dynamicbg.animate().scaleX(3f).scaleY(3f).setDuration(800).start()

            // change color of button
            btnsave.setTextColor(Color.parseColor("#FDE34A"))

            // save to local storage
            editor.putString(themeku, "yellow")
            editor.apply()

            // timer for change the holderbg
            val handler = Handler()
            handler.postDelayed({
                holderbg.scaleX = 3f
                holderbg.scaleY = 3f
                holderbg.setBackgroundResource(R.drawable.bgyellow)
                dynamicbg.scaleX = 0f
                dynamicbg.scaleY = 0f
            }, 850)
        }

        // set function of changing theme
        btngreen.setOnClickListener{ // scale animation
            btngreen.animate().scaleX(1.5f).scaleY(1.5f).setDuration(350).start()

            // default the scale buttons
            btnyellow.animate().translationY(0f).scaleX(1f).scaleY(1f).setDuration(350).start()
            btnpurple.animate().translationY(0f).scaleX(1f).scaleY(1f).setDuration(350).start()
            btnred.animate().translationY(0f).scaleX(1f).scaleY(1f).setDuration(350).start()

            // change the background
            dynamicbg.setBackgroundResource(R.drawable.bggreen)
            dynamicbg.animate().scaleX(3f).scaleY(3f).setDuration(800).start()

            // change color of button
            btnsave.setTextColor(Color.parseColor("#1bac9c"))

            // save to local storage
            editor.putString(themeku, "green")
            editor.apply()

            // timer for change the holderbg
            val handler = Handler()
            handler.postDelayed({
                holderbg.scaleX = 3f
                holderbg.scaleY = 3f
                holderbg.setBackgroundResource(R.drawable.bggreen)
                dynamicbg.scaleX = 0f
                dynamicbg.scaleY = 0f
            }, 850)
        }

        // set function of changing theme
        btnpurple.setOnClickListener { // scale animation
            btnpurple.animate().translationY(20f).scaleX(1.5f).scaleY(1.5f).setDuration(350).start()

            // default the scale buttons
            btnyellow.animate().translationY(0f).scaleX(1f).scaleY(1f).setDuration(350).start()
            btngreen.animate().translationY(0f).scaleX(1f).scaleY(1f).setDuration(350).start()
            btnred.animate().translationY(0f).scaleX(1f).scaleY(1f).setDuration(350).start()

            // change the background
            dynamicbg.setBackgroundResource(R.drawable.bgpurple)
            dynamicbg.animate().scaleX(3f).scaleY(3f).setDuration(800).start()

            // change color of button
            btnsave.setTextColor(Color.parseColor("#E03FA2"))

            // save to local storage
            editor.putString(themeku, "purple")
            editor.apply()

            // timer for change the holderbg
            val handler = Handler()
            handler.postDelayed({
                holderbg.scaleX = 3f
                holderbg.scaleY = 3f
                holderbg.setBackgroundResource(R.drawable.bgpurple)
                dynamicbg.scaleX = 0f
                dynamicbg.scaleY = 0f
            }, 850)
        }

        // set function of changing theme
        btnred.setOnClickListener{ // scale animation
            btnred.animate().translationY(20f).scaleX(1.5f).scaleY(1.5f).setDuration(350).start()

            // default the scale buttons
            btngreen.animate().translationY(0f).scaleX(1f).scaleY(1f).setDuration(350).start()
            btnyellow.animate().translationY(0f).scaleX(1f).scaleY(1f).setDuration(350).start()
            btnpurple.animate().translationY(0f).scaleX(1f).scaleY(1f).setDuration(350).start()

            // change the background
            dynamicbg.setBackgroundResource(R.drawable.bgred)
            dynamicbg.animate().scaleX(3f).scaleY(3f).setDuration(800).start()

            // change color of button
            btnsave.setTextColor(Color.parseColor("#B23B3F"))

            // save to local storage
            editor.putString(themeku, "red")
            editor.apply()

            // timer for change the holderbg
            val handler = Handler()
            handler.postDelayed({
                holderbg.scaleX = 3f
                holderbg.scaleY = 3f
                holderbg.setBackgroundResource(R.drawable.bgred)
                dynamicbg.scaleX = 0f
                dynamicbg.scaleY = 0f
            }, 850)
        }

        //Drawer Action Bar code
        toggle = ActionBarDrawerToggle(this, drawer_final_mood, R.string.open, R.string.close)
        drawer_final_mood.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        nav_view_final_mood.setNavigationItemSelectedListener {
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