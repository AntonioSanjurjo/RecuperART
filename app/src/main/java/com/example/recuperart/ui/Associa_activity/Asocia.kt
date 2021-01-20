package com.example.recuperart.ui.Associa_activity

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.KeyEvent
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.EditorInfo
import android.widget.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.example.recuperart.R
import com.example.recuperart.common.MyApp
import com.example.recuperart.data.ExperienceData
import com.example.recuperart.ui.Dibuja
import com.example.recuperart.ui.experience.VisitasPasadas
import kotlinx.android.synthetic.main.activity_asocia.*


class Asocia : AppCompatActivity(), View.OnClickListener {

    //Local variables used in functions
    //private var musicPlayer : ArrayList<MediaPlayer> = ArrayList(12)
    lateinit var toggle: ActionBarDrawerToggle
    private var musicplayer : MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asocia)

        Toast.makeText(MyApp.instance,
            "Fes servir cascos per no interrompre a altres persones", Toast.LENGTH_LONG ).show()

        //Evitar solapamiento
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)

        //Visible --> Gone
        val assDescrip : TextView = findViewById(R.id.associates_description)
        val listView: ListView = findViewById(R.id.associates_list)
        val song: EditText = findViewById(R.id.associates_song)
        val btnBSS : Button = findViewById(R.id.buttonSeguent)

        //Gone --> Visible
        val musDescrip : TextView = findViewById(R.id.associates_music)
        val musicButtons : ScrollView = findViewById(R.id.buttonList)
        val btnNext: Button = findViewById(R.id.buttonAsocia)

        //Music buttons onClickListener
        //val classic : Button = findViewById(R.id.classical)
        classical.setOnClickListener(this)
        blues.setOnClickListener(this)
        jazz.setOnClickListener(this)
        rock.setOnClickListener(this)
        soul.setOnClickListener(this)
        metal.setOnClickListener(this)
        pop.setOnClickListener(this)
        disco.setOnClickListener(this)
        ska.setOnClickListener(this)
        reggae.setOnClickListener(this)
        flamenco.setOnClickListener(this)
        hiphop.setOnClickListener(this)
        buttonSeguent.setOnClickListener(this)
        buttonAsocia.setOnClickListener(this)

        //Local variables
        val songslist: ArrayList<String> = ArrayList()
        var adaptador: ArrayAdapter<String>
        var musicdata : String = ""
        /*val btnPlay: Button = findViewById(R.id.buttonSpotify)
        btnPlay.setOnClickListener {
            val r = Intent(this, BackgroundSoundService::class.java)
            startService(r)
        }*/

        //Add to list with ENTER/SEND button in Android Keyboard
        song.imeOptions = EditorInfo.IME_ACTION_SEND
        song.setOnKeyListener { _, keyCode, keyEvent ->
            //If the keyEvent is a key-down event on the "Enter/Send" button
            if ((keyEvent.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) || (keyCode == EditorInfo.IME_ACTION_SEND)) {
                val text = song.text.toString()
                if (text.isNotEmpty()) {   //Check Request body in order to avoid Exceptions
                    songslist.add(text)
                    musicdata = musicdata + "\n" + text
                    adaptador = ArrayAdapter(
                        this,
                        android.R.layout.simple_list_item_activated_1,
                        songslist
                    )
                    listView.adapter = adaptador
                    song.text = null
                } else {
                    Toast.makeText(
                        applicationContext,
                        "Introdueix una paraula al camp de text",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                true
            } else false
        }

        //Change visibility to show Music Service
        btnBSS.setOnClickListener {
            //Visible-->Gone
            assDescrip.visibility = View.GONE
            listView.visibility = View.GONE
            song.visibility = View.GONE
            btnBSS.visibility = View.GONE
            //Gone--> Visible
            musDescrip.visibility = View.VISIBLE
            musicButtons.visibility = View.VISIBLE
            btnNext.visibility = View.VISIBLE

            ExperienceData.cancion = "Llista de cançons:\n" + musicdata
        }

        //Drawer Action Bar code
        toggle = ActionBarDrawerToggle(this, drawer_asocia, R.string.open, R.string.close)
        drawer_asocia.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        nav_view_asocia.setNavigationItemSelectedListener {
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

    override fun onClick(v: View?) {
        musicplayer?.stop()
        when (v!!.id) {
            //Music plays with buttons click
            R.id.classical -> musicplayer = MediaPlayer.create(this, R.raw.classica)
            R.id.blues -> musicplayer = MediaPlayer.create(this, R.raw.blues)
            R.id.jazz -> musicplayer = MediaPlayer.create(this, R.raw.jazz)
            R.id.rock -> musicplayer = MediaPlayer.create(this, R.raw.rock)
            R.id.soul -> musicplayer = MediaPlayer.create(this, R.raw.soul)
            R.id.metal -> musicplayer = MediaPlayer.create(this, R.raw.metal)
            R.id.pop -> musicplayer = MediaPlayer.create(this, R.raw.pop)
            R.id.disco -> musicplayer = MediaPlayer.create(this, R.raw.disco)
            R.id.ska -> musicplayer = MediaPlayer.create(this, R.raw.ska)
            R.id.reggae -> musicplayer = MediaPlayer.create(this, R.raw.reggae)
            R.id.flamenco -> musicplayer = MediaPlayer.create(this, R.raw.flamenco)
            R.id.hiphop -> musicplayer = MediaPlayer.create(this, R.raw.hiphop)
            R.id.buttonAsocia -> { //Change to Dibuja activity
                val r = Intent(this, Dibuja::class.java)
                startActivity(r)
            }
        }
        Toast.makeText(MyApp.instance,
            "Fes servir cascos per no interrompre a altres persones", Toast.LENGTH_LONG ).show()
        musicplayer?.setVolume(100F, 100F)
        musicplayer?.start()
    }

}