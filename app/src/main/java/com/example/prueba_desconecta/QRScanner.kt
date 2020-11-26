package com.example.prueba_desconecta

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.qrcode.QRCodeReader

class QRScanner : AppCompatActivity() {
    var scan_btn: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qrscanner)
        resultTextView = findViewById<View>(R.id.result_text) as TextView
        scan_btn = findViewById<View>(R.id.btn_scan) as Button
        scan_btn!!.setOnClickListener(mOnClickListener)
        IntentIntegrator(this).setOrientationLocked(false)
        val btn: Button = findViewById(R.id.btn_next)
        btn.setOnClickListener{
            val r = Intent(this, Mood::class.java)
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