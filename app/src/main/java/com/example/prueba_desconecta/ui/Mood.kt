package com.example.prueba_desconecta.ui

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.example.prueba_desconecta.R
import kotlinx.android.synthetic.main.activity_mood.*

class Mood : AppCompatActivity() {

    var SHARED_PREFS = "codeTheme"
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mood)
        val btngreen: Button = findViewById(R.id.btngreen)
        val btnblue : Button = findViewById(R.id.btnblue)
        val btnpurple : Button = findViewById(R.id.btnpurple)
        val btnorange : Button = findViewById(R.id.btnorange)
        val holderbg : View = findViewById(R.id.holderbg)
        val dynamicbg : View = findViewById(R.id.dynamicbg)
        // get the id
        val btnsave : Button = findViewById(R.id.btnsave)

        // give an event to next activity
        btnsave.setOnClickListener(View.OnClickListener {
            val a = Intent(this@Mood, Monsters::class.java)
            startActivity(a)
        })


        // set the first-time background
        holderbg.setBackgroundResource(R.drawable.bggreen)
        holderbg.setScaleY(3f)
        holderbg.setScaleX(3f)

        // set the scale of button clicked
        btngreen.setScaleY(1.5f)
        btngreen.setScaleX(1.5f)

        // save to local storage (default)
        val themeku = ""
        val sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(themeku, "green")
        editor.apply()

        // set function of changing theme
        btnblue.setOnClickListener(View.OnClickListener { // scale animation
            btnblue.animate().translationY(20f).scaleX(1.5f).scaleY(1.5f).setDuration(350).start()

            // default the scale buttons
            btngreen.animate().translationY(0f).scaleX(1f).scaleY(1f).setDuration(350).start()
            btnpurple.animate().translationY(0f).scaleX(1f).scaleY(1f).setDuration(350).start()
            btnorange.animate().translationY(0f).scaleX(1f).scaleY(1f).setDuration(350).start()

            // change the background
            dynamicbg.setBackgroundResource(R.drawable.bgblue)
            dynamicbg.animate().scaleX(3f).scaleY(3f).setDuration(800).start()

            // change color of button
            btnsave.setTextColor(Color.parseColor("#3498db"))

            // save to local storage
            val themeku = ""
            val sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString(themeku, "blue")
            editor.apply()

            // timer for change the holderbg
            val handler = Handler()
            handler.postDelayed({
                holderbg.setScaleX(3f)
                holderbg.setScaleY(3f)
                holderbg.setBackgroundResource(R.drawable.bgblue)
                dynamicbg.setScaleX(0f)
                dynamicbg.setScaleY(0f)
            }, 850)
        })

        // set function of changing theme
        btngreen.setOnClickListener(View.OnClickListener { // scale animation
            btngreen.animate().scaleX(1.5f).scaleY(1.5f).setDuration(350).start()

            // default the scale buttons
            btnblue.animate().translationY(0f).scaleX(1f).scaleY(1f).setDuration(350).start()
            btnpurple.animate().translationY(0f).scaleX(1f).scaleY(1f).setDuration(350).start()
            btnorange.animate().translationY(0f).scaleX(1f).scaleY(1f).setDuration(350).start()

            // change the background
            dynamicbg.setBackgroundResource(R.drawable.bggreen)
            dynamicbg.animate().scaleX(3f).scaleY(3f).setDuration(800).start()

            // change color of button
            btnsave.setTextColor(Color.parseColor("#1bac9c"))

            // save to local storage
            val themeku = ""
            val sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString(themeku, "green")
            editor.apply()

            // timer for change the holderbg
            val handler = Handler()
            handler.postDelayed({
                holderbg.setScaleX(3f)
                holderbg.setScaleY(3f)
                holderbg.setBackgroundResource(R.drawable.bggreen)
                dynamicbg.setScaleX(0f)
                dynamicbg.setScaleY(0f)
            }, 850)
        })

        // set function of changing theme
        btnpurple.setOnClickListener(View.OnClickListener { // scale animation
            btnpurple.animate().translationY(20f).scaleX(1.5f).scaleY(1.5f).setDuration(350).start()

            // default the scale buttons
            btnblue.animate().translationY(0f).scaleX(1f).scaleY(1f).setDuration(350).start()
            btngreen.animate().translationY(0f).scaleX(1f).scaleY(1f).setDuration(350).start()
            btnorange.animate().translationY(0f).scaleX(1f).scaleY(1f).setDuration(350).start()

            // change the background
            dynamicbg.setBackgroundResource(R.drawable.bgpurple)
            dynamicbg.animate().scaleX(3f).scaleY(3f).setDuration(800).start()

            // change color of button
            btnsave.setTextColor(Color.parseColor("#E03FA2"))

            // save to local storage
            val themeku = ""
            val sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString(themeku, "purple")
            editor.apply()

            // timer for change the holderbg
            val handler = Handler()
            handler.postDelayed({
                holderbg.setScaleX(3f)
                holderbg.setScaleY(3f)
                holderbg.setBackgroundResource(R.drawable.bgpurple)
                dynamicbg.setScaleX(0f)
                dynamicbg.setScaleY(0f)
            }, 850)
        })

        // set function of changing theme
        btnorange.setOnClickListener(View.OnClickListener { // scale animation
            btnorange.animate().translationY(20f).scaleX(1.5f).scaleY(1.5f).setDuration(350).start()

            // default the scale buttons
            btngreen.animate().translationY(0f).scaleX(1f).scaleY(1f).setDuration(350).start()
            btnblue.animate().translationY(0f).scaleX(1f).scaleY(1f).setDuration(350).start()
            btnpurple.animate().translationY(0f).scaleX(1f).scaleY(1f).setDuration(350).start()

            // change the background
            dynamicbg.setBackgroundResource(R.drawable.bgorange)
            dynamicbg.animate().scaleX(3f).scaleY(3f).setDuration(800).start()

            // change color of button
            btnsave.setTextColor(Color.parseColor("#FF8D7E"))

            // save to local storage
            val themeku = ""
            val sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString(themeku, "orange")
            editor.apply()

            // timer for change the holderbg
            val handler = Handler()
            handler.postDelayed({
                holderbg.setScaleX(3f)
                holderbg.setScaleY(3f)
                holderbg.setBackgroundResource(R.drawable.bgorange)
                dynamicbg.setScaleX(0f)
                dynamicbg.setScaleY(0f)
            }, 850)
        })
        //Drawer Action Bar code
        toggle = ActionBarDrawerToggle(this, drawer_mood, R.string.open, R.string.close)
        drawer_mood.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        nav_view_mood.setNavigationItemSelectedListener {
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