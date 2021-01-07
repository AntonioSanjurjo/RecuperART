package com.example.prueba_desconecta.ui.ui.elije

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.prueba_desconecta.R
import com.example.prueba_desconecta.io.Constantes
import com.example.prueba_desconecta.ui.Mood
import com.google.zxing.integration.android.IntentIntegrator

class QrFragment : Fragment() {
    private var scanBtn: Button? = null
    private var fragmentView: View? = null
    var resultTextView: TextView? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        resultTextView = fragmentView?.findViewById<View>(R.id.result_text) as TextView
        scanBtn = fragmentView?.findViewById<View>(R.id.btn_scan) as Button
        scanBtn!!.setOnClickListener(mOnClickListener)
        val btn: Button = fragmentView!!.findViewById(R.id.btn_next)
        btn.setOnClickListener{
            val r = Intent(activity, Mood::class.java)
            startActivity(r)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentView = inflater.inflate(R.layout.fragment_qr, container, false)
        return fragmentView
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) if (result.contents != null) {
            Constantes.ID= result.contents
            val r = Intent(activity, Mood::class.java)
            startActivity(r)
        } else {
            resultTextView!!.text = "Error al escanear el código de barras"
        }
    }

    private val mOnClickListener =
        View.OnClickListener { v ->
            when (v.id) {
                R.id.btn_scan ->
                    IntentIntegrator.forSupportFragment(this).initiateScan(IntentIntegrator.QR_CODE_TYPES)
            }
        }
}