package com.example.prueba_desconecta

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.prueba_desconecta.Descubre
import com.example.prueba_desconecta.R
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.qrcode.QRCodeReader

class MainActivity : AppCompatActivity() {
    var scan_btn: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultTextView = findViewById<View>(R.id.result_text) as TextView
        scan_btn = findViewById<View>(R.id.btn_scan) as Button
        scan_btn!!.setOnClickListener(mOnClickListener)

        //Añadir val para tipo de actividad y seleccionar según el resultat del código QR

        val btn: Button = findViewById(R.id.buttonMain)
        btn.setOnClickListener{
            val r = Intent(this, Descubre::class.java)
            startActivity(r)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) if (result.contents != null) {
            resultTextView!!.text = """
                El código de barras es:
                ${result.contents}
                """.trimIndent()
        } else {
            resultTextView!!.text = "Error al escanear el código de barras"
        }
    }

    private val mOnClickListener =
        View.OnClickListener { v ->
            when (v.id) {
                R.id.btn_scan ->
                    IntentIntegrator(this).initiateScan(IntentIntegrator.QR_CODE_TYPES)
            }
        }

    companion object {
        var resultTextView: TextView? = null
    }
}