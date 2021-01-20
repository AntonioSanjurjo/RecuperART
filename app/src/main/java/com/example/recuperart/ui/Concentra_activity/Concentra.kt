package com.example.recuperart.ui.Concentra_activity

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.os.StrictMode
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import android.widget.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.example.recuperart.R
import com.example.recuperart.data.ExperienceData
import com.example.recuperart.ui.Associa_activity.Asocia
import com.example.recuperart.ui.experience.VisitasPasadas
import kotlinx.android.synthetic.main.activity_concentra.*
import java.io.BufferedInputStream
import java.net.HttpURLConnection
import java.net.URL
import kotlin.math.ceil


class Concentra : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    //Request variables
    private var lastDown : Long = 0
    private var wordCloud = ""

        @SuppressLint("ClickableViewAccessibility")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_concentra)

            //Visible-->Gone pushing btnWC
            val word : EditText = findViewById(R.id.emotionWord)
            val clock : LottieAnimationView = findViewById(R.id.clockCreate)
            val instructions : TextView = findViewById(R.id.concentrate_instructions)
            val concentrateTitle : TextView = findViewById(R.id.concentrate)
            val btnWC : Button = findViewById(R.id.createWordCloud)

            //Gone-->Visible pushing btnWC
            val imageView : ImageView = findViewById(R.id.resultWC)
            val wordCloudExplanation : TextView = findViewById(R.id.wordcloud_explanation)
            val buttonNext : Button = findViewById(R.id.buttonConcentra)
            val wordCloudTitle : TextView = findViewById(R.id.wordcloud_e)

            //Evitar error NetworkOnMainThreadException
            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
            //Button to create String by pulsating time
            clock.setOnTouchListener { _, event ->
                if (word.text.trim().isNotEmpty()) {   //Check Request body in order to avoid Exceptions
                    if (event.action == MotionEvent.ACTION_DOWN) {
                        lastDown = System.currentTimeMillis()
                        clockAnimation(clock)
                        clock.loop(true)
                    } else if (event.action == MotionEvent.ACTION_UP) {
                        clock.loop(false)
                        var lastDuration = ceil(((System.currentTimeMillis() - lastDown) / 1000).toDouble()).toInt()
                        if (lastDuration > 10) {
                            lastDuration = 10
                        }
                        for (num in 1..lastDuration) {
                            wordCloud = wordCloud + word.text + " "
                        }
                        word.text = null
                    }
                } else {
                    Toast.makeText(
                        applicationContext,
                        "Introdueix una paraula al camp de text",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                true
            }

            btnWC.setOnClickListener{
                //Change visibility in layout when Request is sent
                instructions.visibility = View.GONE
                clock.visibility = View.GONE
                word.visibility = View.GONE
                btnWC.visibility = View.GONE
                concentrateTitle.visibility = View.GONE
                imageView.visibility = View.VISIBLE
                buttonNext.visibility = View.VISIBLE
                wordCloudExplanation.visibility = View.VISIBLE
                wordCloudTitle.visibility = View.VISIBLE
                //Send POST Request to BE and set its response to an ImageView
                val url = URL("http://pae-ics.etsetb.upc.edu/WordCloud/getWordCloud")
                if (wordCloud.trim().isNotEmpty()) {      //Check Request body in order to avoid Exceptions
                    val con: HttpURLConnection = url.openConnection() as HttpURLConnection
                    con.requestMethod = "POST"
                    con.setRequestProperty("Content-Type", "text/plain")
                    con.doOutput = true
                    con.outputStream.use { os ->
                        val input: ByteArray = wordCloud.toByteArray()
                        os.write(input, 0, input.size)
                    }
                    BufferedInputStream(con.inputStream).use { bis ->
                        val bitmap = BitmapFactory.decodeStream(bis)
                        ExperienceData.workcloud = bitmap
                        imageView.setImageBitmap(bitmap)
                    }
                } else {
                    imageView.setImageResource(R.drawable.wcerror)
                    val drawable = imageView.drawable as BitmapDrawable
                    ExperienceData.workcloud = drawable.bitmap
                }
            }

            //Change to Asocia activity
            buttonNext.setOnClickListener{
                val r = Intent(this, Asocia::class.java)
                startActivity(r)
            }

            //Drawer Action Bar code
            toggle = ActionBarDrawerToggle(this, drawer_concentrate, R.string.open, R.string.close)
            drawer_concentrate.addDrawerListener(toggle)
            toggle.syncState()
            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            nav_view_concentrate.setNavigationItemSelectedListener {
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

    //Starts animation
    private fun clockAnimation(imageView: LottieAnimationView) {
        imageView.setAnimation(R.raw.redbuttonanimation)
        imageView.playAnimation()
    }
}