package com.example.prueba_desconecta.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prueba_desconecta.io.response.MuseuByIdContentResponse
import com.example.prueba_desconecta.repository.MuseuContentDBRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class ViewModelPrueba( private val repository: MuseuContentDBRepository): ViewModel() {

    var myResponse: MutableLiveData<Response<MuseuByIdContentResponse>> = MutableLiveData()

    fun getMuseuContentById(number: Int){

        viewModelScope.launch {
            var response =repository.getMuseuContentById(number)
            myResponse.value = response
        }
    }


}