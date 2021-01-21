package com.example.recuperart.ui

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.airbnb.lottie.LottieAnimationView
import com.example.recuperart.R
import com.example.recuperart.data.ExperienceData
import com.example.recuperart.ui.experience.VisitasPasadas
import kotlinx.android.synthetic.main.activity_dibuja.*
import java.security.AccessController.getContext


class Dibuja : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    private val REQUEST_IMAGE_CAPTURE = 1
    private var dibuja = false
    private val TAKE_PHOTO = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dibuja)

        val lottieCam : LottieAnimationView = findViewById(R.id.openCamera)
        cameraAnimation(lottieCam)
        lottieCam.loop(true)
        lottieCam.setOnClickListener{
            dispatchTakePictureIntent()
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
                // check for camera permission
                val permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
                } else {
                    ActivityCompat.requestPermissions(
                        (this)!!, arrayOf(Manifest.permission.CAMERA),
                        TAKE_PHOTO
                    )
                }
            }
        }
    }


    private fun cameraAnimation(imageView: LottieAnimationView) : Boolean {
        imageView.setAnimation(R.raw.camerai)
        imageView.playAnimation()
        return true
    }

}