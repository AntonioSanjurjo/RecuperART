package com.example.prueba_desconecta.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prueba_desconecta.io.response.MediaMuseuByMuseuResponse
import com.example.prueba_desconecta.io.response.ObrasByMuseuResponse
import com.example.prueba_desconecta.repository.MediaMuseuRepository
import com.example.prueba_desconecta.repository.ObrasRepository
import kotlinx.coroutines.launch
import retrofit2.Response
import kotlin.properties.Delegates

class ViewModelObras(private val repository: ObrasRepository): ViewModel() {

    var myResponse: MutableLiveData<Response<ObrasByMuseuResponse>> = MutableLiveData()

    fun getObras(number: Int){

        viewModelScope.launch {
            var response =repository.getObresByMuseu(number)
            myResponse.value = response
        }


    }
    fun getImages(number: Int){


    }
}