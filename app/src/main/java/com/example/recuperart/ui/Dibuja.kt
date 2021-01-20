package com.example.recuperart.ui

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.provider.MediaStore
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.example.recuperart.R
import com.example.recuperart.data.ExperienceData
import com.example.recuperart.ui.experience.VisitasPasadas
import kotlinx.android.synthetic.main.activity_dibuja.*


class Dibuja : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    private val REQUEST_IMAGE_CAPTURE = 1
    private var dibuja = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dibuja)

        val lottieCam : LottieAnimationView = findViewById(R.id.openCamera)
        cameraAnimation(lottieCam, R.raw.camerai)
        lottieCam.loop(true)
        lottieCam.setOnClickListener{
            dispatchTakePictureIntent()
            lottieCam.loop(false)
        }

        val btn: Button = findViewById(R.id.buttonDibuixa)
        btn.setOnClickListener{
            if(!dibuja) {
                lottieCam.setImageResource(R.drawable.wcerror)
                val drawable = lottieCam.drawable as BitmapDrawable
                ExperienceData.dibujo = drawable.bitmap
            }
            val r = Intent(this, Escribe::class.java)
            startActivity(r)
        }

        //Drawer Action Bar code
        toggle = ActionBarDrawerToggle(this, drawer_draw, R.string.open, R.string.close)
        drawer_draw.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        nav_view_draw.setNavigationItemSelectedListener {
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


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            dibuja = true
            val imageBitmap = data?.extras?.get("data") as Bitmap
            ExperienceData.dibujo = imageBitmap
            val imageView : ImageView = findViewById(R.id.openCamera)
            imageView.setImageBitmap(imageBitmap)
        }
    }

    private fun dispatchTakePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
    }


    private fun cameraAnimation(imageView: LottieAnimationView, animation: Int) : Boolean {
        imageView.setAnimation(animation)
        imageView.playAnimation()
        return true
    }

}