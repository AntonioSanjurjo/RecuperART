package com.example.prueba_desconecta.ui

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.airbnb.lottie.LottieAnimationView
import com.example.prueba_desconecta.R
import kotlinx.android.synthetic.main.activity_dibuja.*


class Dibuja : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    val REQUEST_IMAGE_CAPTURE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dibuja)

        val btn: Button = findViewById(R.id.buttonDibuixa)
        btn.setOnClickListener{
            val r = Intent(this, Escribe::class.java)
            startActivity(r)
        }

        val lottieCam : LottieAnimationView = findViewById(R.id.openCamera)
        cameraAnimation(lottieCam, R.raw.camerai)
        lottieCam.loop(true)
        lottieCam.setOnClickListener{
            dispatchTakePictureIntent()
            lottieCam.loop(false)
        }

        //Drawer Action Bar code
        toggle = ActionBarDrawerToggle(this, drawer_draw, R.string.open, R.string.close)
        drawer_draw.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        nav_view_draw.setNavigationItemSelectedListener {
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

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        when(requestCode) {
            100 ->
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(applicationContext, "Permission Granted", Toast.LENGTH_SHORT)
                        .show();

                    // main logic
                } else {
                    Toast.makeText(getApplicationContext(), "Permission Denied", Toast.LENGTH_SHORT)
                        .show();
                }
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
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