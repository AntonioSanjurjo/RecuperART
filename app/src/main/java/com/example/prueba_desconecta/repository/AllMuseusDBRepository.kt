package com.example.prueba_desconecta.repository

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.prueba_desconecta.common.MyApp
import com.example.prueba_desconecta.io.ApiAdapter
import com.example.prueba_desconecta.io.response.AllMuseusResponse
import com.example.prueba_desconecta.ui.PreviewMuseo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AllMuseusDBRepository : Callback<AllMuseusResponse> {
    var allMuseus : MutableLiveData<ArrayList<PreviewMuseo>>? =  null
    var museoDefault: PreviewMuseo = PreviewMuseo()
    init{
        allMuseus =  callallmuseus()
        museoDefault.createDefault(0,"Començar sense museu", "Feu clic aquí")
    }

    fun  callallmuseus(): MutableLiveData<ArrayList<PreviewMuseo>>? {
        if(allMuseus == null){
            allMuseus = MutableLiveData<ArrayList<PreviewMuseo>>()
        }
        var call = (ApiAdapter.getApiService()?.allMuseus)?.also {
            it.enqueue(this)
        }
        return allMuseus
    }

    override fun onResponse(call: Call<AllMuseusResponse>, response: Response<AllMuseusResponse>) {
        if (response.isSuccessful()) {
            var arraymuseo = response.body()?.museos
            arraymuseo?.add(0, museoDefault)
            allMuseus!!.setValue(arraymuseo)
        }
    }

    override fun onFailure(call: Call<AllMuseusResponse>, t: Throwable) {
        Toast.makeText(MyApp.instance, "Error en la llamada", Toast.LENGTH_LONG).show()
    }
}