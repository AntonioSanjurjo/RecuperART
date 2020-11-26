package com.example.prueba_desconecta

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_crea.*
import org.json.JSONObject


class Crea : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crea)
        //val resp : TextView = findViewById(R.id.httpResp)

        val btn: Button = findViewById(R.id.buttonCrea)
        btn.setOnClickListener{
            val r = Intent(this, Revisita::class.java)
            startActivity(r)
            //val queue = Volley.newRequestQueue(this)
            //val url = "http://pae-ics.etsetb.upc.edu/api"
            //val url = httpProve.text.toString()

            //val jsonArrayReq = JsonArrayRequest(url,Response.Listener {
            //        response ->
            //           resp.setText("Response is: ".format(response.toString()))
            //         },
            //        Response.ErrorListener { error->
            //          resp.setText(error.message)
            //        })
        // Request a string response from the provided URL.
            //val jsonRequest = JsonObjectRequest(Request.Method.GET, url, null,  Response.Listener {
            //    response ->
            //       resp.setText("Response is: ".format(response.toString()))
           //     },
            //    Response.ErrorListener { error->
            //      resp.setText(error.message)
            //    })

            //queue.add(jsonArrayReq)


            // Access the RequestQueue through your singleton class.
            //https://developer.android.com/training/volley/requestqueue
            //MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)
        }

    }
}