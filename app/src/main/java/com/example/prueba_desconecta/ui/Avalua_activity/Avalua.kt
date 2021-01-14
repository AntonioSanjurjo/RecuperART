package com.example.prueba_desconecta.ui.Avalua_activity

import androidx.appcompat.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.example.prueba_desconecta.R
import com.example.prueba_desconecta.ui.MainActivity
import com.example.prueba_desconecta.ui.ui.elije.Elige
import kotlinx.android.synthetic.main.activity_avalua.*


class Avalua : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avalua)

        webView = findViewById(R.id.webview)
        webView.settings.javaScriptEnabled = true
        webView.loadUrl("http://avaluacio.recuperart-19.org")
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                view.loadUrl(url)
                return true
            }
        }
        buttonFinish.setOnClickListener {
            val builder: AlertDialog.Builder = AlertDialog.Builder(this)
            builder.setTitle(R.string.app_name)
                .setIcon(R.drawable.recuperart)
                .setMessage("Què vols fer ara?")
                .setCancelable(false)
                .setPositiveButton("Tornar al menú") { dialogInterface: DialogInterface, _: Int ->
                    val intent = Intent(this, Elige::class.java)
                    startActivity(intent)
                    dialogInterface.cancel()
                }
                .setNegativeButton("Sortir") { dialogInterface: DialogInterface, _: Int ->
                    val intent = Intent(this, MainActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                    intent.putExtra("FINISH", true)
                    startActivity(intent)
                    dialogInterface.cancel()

                }
            val alert : AlertDialog = builder.create()
            alert.show()
        }

        //Drawer Action Bar code
        toggle = ActionBarDrawerToggle(this, drawer_evaluate, R.string.open, R.string.close)
        drawer_evaluate.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        nav_view_evaluate.setNavigationItemSelectedListener {
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