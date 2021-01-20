package com.example.recuperart.ui


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.recuperart.R
import com.example.recuperart.ui.experience.VisitasPasadas
import com.example.recuperart.ui.ui.elije.Elige
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Turn off the app
        if (intent.getBooleanExtra("FINISH", false)) {
            finish()
        }

        buttonMain.setOnClickListener {
            val r = Intent(this, Elige::class.java)
            startActivity(r)
        }

        //Drawer Action Bar code
        toggle = ActionBarDrawerToggle(this, drawer_main, R.string.open, R.string.close)
        drawer_main.addDrawerListener(toggle)
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