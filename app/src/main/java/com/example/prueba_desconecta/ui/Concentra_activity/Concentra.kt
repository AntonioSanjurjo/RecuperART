package com.example.prueba_desconecta.ui.Concentra_activity

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.example.prueba_desconecta.R
import com.example.prueba_desconecta.io.response.WordCloud
import com.example.prueba_desconecta.ui.Associa_activity.Asocia
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.BufferedInputStream
import java.net.HttpURLConnection
import java.net.URL


class Concentra : AppCompatActivity() {


    //Request variables
    var lastDown : Long = 0
    var wordCloud = ""

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_concentra)

            //Visible-->Gone pushing btnWC
            var word : EditText = findViewById(R.id.emotionWord)
            var clock : LottieAnimationView = findViewById(R.id.clockCreate)
            val instructions : TextView = findViewById(R.id.concentrate_instructions)
            val concentrateTitle : TextView = findViewById(R.id.concentrate)
            val btnWC : Button = findViewById(R.id.createWordCloud)

            //Gone-->Visible pushing btnWC
            var imageView : ImageView = findViewById(R.id.resultWC)
            val wordCloudExplanation : TextView = findViewById(R.id.wordcloud_explanation)
            val buttonNext : Button = findViewById(R.id.buttonConcentra)
            val wordCloudTitle : TextView = findViewById(R.id.wordcloud)

            //Evitar error NetworkOnMainThreadException
            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
            //Button to create String by pulsating time
            clock.setOnTouchListener(OnTouchListener { view, event ->
                if (event.action == MotionEvent.ACTION_DOWN) {
                    if(word.text.trim().length > 0) {   //Check Request body in order to avoid Exceptions
                        lastDown = System.currentTimeMillis()
                        clockAnimation(clock, R.raw.redbuttonanimation)
                        clock.loop(true)
                    } else {
                        Toast.makeText(getApplicationContext(), "Introdueix una paraula al camp de text", Toast.LENGTH_SHORT).show()
                    }
                } else if (event.action == MotionEvent.ACTION_UP) {
                    clock.loop(false)
                    var lastDuration = (System.currentTimeMillis() - lastDown) / 1000
                    if (lastDuration > 10) {
                        lastDuration = 10
                    }
                    for (num in 1..lastDuration) {
                        wordCloud = wordCloud + word.text + " "
                    }
                    word.setText(null)
                }
                true
            })

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
                if (wordCloud.trim().length > 0) {      //Check Request body in order to avoid Exceptions
                    val con: HttpURLConnection = url.openConnection() as HttpURLConnection
                    con.setRequestMethod("POST");
                    con.setRequestProperty("Content-Type", "text/plain")
                    con.setDoOutput(true)
                    con.outputStream.use { os ->
                        val input: ByteArray = wordCloud.toByteArray()
                        os.write(input, 0, input.size)
                    }
                    BufferedInputStream(con.inputStream).use { bis ->
                        var bitmap = BitmapFactory.decodeStream(bis)
                        imageView.setImageBitmap(bitmap)
                    }
                } else {
                    imageView.setImageResource(R.drawable.wcerror)
                }
            }

            //Change to Asocia activity
            val btnNext : Button = findViewById(R.id.buttonConcentra)
            btnNext.setOnClickListener{
                val r = Intent(this, Asocia::class.java)
                startActivity(r)
            }
    }

    //Starts animation
    private fun clockAnimation(imageView: LottieAnimationView, animation: Int) : Boolean {
        imageView.setAnimation(animation)
        imageView.playAnimation()
        return true
    }
}