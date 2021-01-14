package com.example.prueba_desconecta.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prueba_desconecta.io.response.MediaObraByObraResponse
import com.example.prueba_desconecta.io.response.ObrasByMuseuResponse
import com.example.prueba_desconecta.repository.MediaObraRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class ViewModelMediaObra(private val repository: MediaObraRepository ):ViewModel() {

    var myResponse: MutableLiveData<Response<MediaObraByObraResponse>> = MutableLiveData()

    fun getMediaObra(number: Int){

        viewModelScope.launch {
            var response =repository.getObraMedia(number)
            myResponse.value = response
        }
    }
}