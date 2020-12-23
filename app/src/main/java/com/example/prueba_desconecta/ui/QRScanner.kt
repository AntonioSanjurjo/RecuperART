package com.example.prueba_desconecta.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.prueba_desconecta.R
import com.example.prueba_desconecta.io.ApiAdapter
import com.example.prueba_desconecta.io.ApiClient
import com.example.prueba_desconecta.io.ApiService
import com.example.prueba_desconecta.io.ApiServiceInterceptor
import com.example.prueba_desconecta.io.response.MuseuByIdResponse
import com.example.prueba_desconecta.io.response.MuseuContentByIdResponse
import com.google.zxing.integration.android.IntentIntegrator
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback


class QRScanner : AppCompatActivity(){
    var scan_btn: Button? = null
    var apiService: ApiService? = null
    var apiClient: ApiClient? = null
    var museo: Museo? =null;
    var respuesta: String =""


    init {
        apiClient =ApiClient(respuesta)
        apiService = apiClient?.getApiService()
        museo = TheMuseo()

    }

    fun TheMuseo(): Museo?{

        if (museo== null){
          museo=Museo()

        }

        var call = (ApiAdapter.getApiService()?.museuContentById)?.also {
            it.enqueue( object: Callback<MuseuContentByIdResponse> {

                override fun onFailure(call: Call<MuseuContentByIdResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }

                override fun onResponse(
                    call: Call<MuseuContentByIdResponse>,
                    response: Response<MuseuContentByIdResponse>
                ) {
                    var Museu: MuseuContentByIdResponse? = response.body()
                    var museo = Museu?.ans
                }


            })
        }
        return museo
    }



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
        respuesta = result.contents;








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