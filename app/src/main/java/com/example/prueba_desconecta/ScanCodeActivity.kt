package com.example.prueba_desconecta

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.Result
import me.dm7.barcodescanner.zxing.ZXingScannerView

class ScanCodeActivity : AppCompatActivity(), ZXingScannerView.ResultHandler {
    var ScannerView: ZXingScannerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ScannerView = ZXingScannerView(this)
        setContentView(ScannerView)
    }

    override fun handleResult(result: Result) {
        QRScanner.resultTextView!!.text = result.text
        onBackPressed()
    }

    override fun onPause() {
        super.onPause()
        ScannerView!!.stopCamera()
    }

    override fun onResume() {
        super.onResume()
        ScannerView!!.setResultHandler(this)
        ScannerView!!.startCamera()
    }
}