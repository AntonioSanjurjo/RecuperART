package com.example.prueba_desconecta.ui.Associa_activity

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.View.OnKeyListener
import android.view.WindowManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.prueba_desconecta.R
import com.example.prueba_desconecta.ui.Dibuja


class Asocia : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asocia)
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)

        var listView: ListView = findViewById(R.id.associates_list)
        var song: EditText = findViewById(R.id.associates_song)
        var arrayList: ArrayList<String> = ArrayList()

        var adaptador = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
        /*val btnPlay: Button = findViewById(R.id.buttonSpotify)
        btnPlay.setOnClickListener {
            val r = Intent(this, BackgroundSoundService::class.java)
            startActivity(r)
        }*/

        val btnNext: Button = findViewById(R.id.buttonAsocia)
        btnNext.setOnClickListener {
            val r = Intent(this, Dibuja::class.java)
            startActivity(r)
        }

        song.setOnKeyListener(OnKeyListener { view, keyCode, keyevent ->
            //If the keyevent is a key-down event on the "enter" button
            if (keyevent.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                var text = song.text.toString()
                if (text.length > 0) {   //Check Request body in order to avoid Exceptions
                    arrayList.add(text)
                    adaptador = ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1, arrayList)
                    listView.adapter = adaptador
                    song.setText(null)
                } else {
                    Toast.makeText(getApplicationContext(), "Introdueix una paraula al camp de text", Toast.LENGTH_SHORT).show()
                }
                true
            } else false
        })

        val btnAddToList: Button = findViewById(R.id.buttonAddToList)
        btnAddToList.setOnClickListener {
            var text = song.text.toString()
            if (text.length > 0) {   //Check Request body in order to avoid Exceptions
                arrayList.add(text)
                adaptador = ArrayAdapter<String>(
                    this,
                    android.R.layout.simple_list_item_activated_1,
                    arrayList
                )
                listView.adapter = adaptador
                song.setText(null)
            } else {
                Toast.makeText(getApplicationContext(), "Introdueix una paraula al camp de text", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun setTextToList(){

    }
}