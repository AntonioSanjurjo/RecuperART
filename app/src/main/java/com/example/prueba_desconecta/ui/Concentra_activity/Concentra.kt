package com.example.prueba_desconecta.ui.Concentra_activity

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
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


class Concentra : AppCompatActivity(), Callback<WordCloud> {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_concentra)

            //Evitar error NetworkOnMainThreadException
            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)

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

            //Request data
            val url = URL("http://pae-ics.etsetb.upc.edu/WordCloud/getWordCloud")
            var wordCloud = ""

            var lastDown : Long = 0

            clock.setOnTouchListener(OnTouchListener { view, event ->
                if (event.action == MotionEvent.ACTION_DOWN) {
                    lastDown = System.currentTimeMillis()
                    clockAnimation(clock, R.raw.redbuttonanimation)
                    clock.loop(true)
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
                //Change visibility in layout
                instructions.visibility = View.GONE
                clock.visibility = View.GONE
                word.visibility = View.GONE
                btnWC.visibility = View.GONE
                concentrateTitle.visibility = View.GONE
                imageView.visibility = View.VISIBLE
                buttonNext.visibility = View.VISIBLE
                wordCloudExplanation.visibility = View.VISIBLE
                wordCloudTitle.visibility = View.VISIBLE
                //Send POST Request and set Response to ImageView
                //var bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream())
                Log.i("Wordcloud",wordCloud)
                val con: HttpURLConnection = url.openConnection() as HttpURLConnection
                con.setRequestMethod("POST");
                con.setRequestProperty("Content-Type", "text/plain")
                //con.setRequestProperty("Accept", "application/json");
                con.setDoOutput(true)
                con.outputStream.use { os ->
                    val input: ByteArray = wordCloud.toByteArray()
                    os.write(input, 0, input.size)
                }
                BufferedInputStream(con.inputStream).use { bis ->
                    var bitmap = BitmapFactory.decodeStream(bis)
                    imageView.setImageBitmap(bitmap)
                }
            }

            val btnNext : Button = findViewById(R.id.buttonConcentra)
            btnNext.setOnClickListener{
                val r = Intent(this, Asocia::class.java)
                startActivity(r)
            }


    }

    private fun clockAnimation(imageView: LottieAnimationView, animation: Int) : Boolean {
        imageView.setAnimation(animation)
        imageView.playAnimation()
        return true
    }

    override fun onResponse(call: Call<WordCloud>, response: Response<WordCloud>) {
        TODO("Not yet implemented")
    }

    override fun onFailure(call: Call<WordCloud>, t: Throwable) {
        TODO("Not yet implemented")
    }
}