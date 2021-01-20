package com.example.recuperart.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recuperart.io.response.ObrasByMuseuResponse
import com.example.recuperart.repository.ObrasRepository
import kotlinx.coroutines.launch
import retrofit2.Response

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