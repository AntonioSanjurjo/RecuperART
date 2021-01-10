package com.example.prueba_desconecta.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.prueba_desconecta.repository.MediaObraRepository

class ViewModelMedIaObraFactory(private val repository: MediaObraRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ViewModelMediaObra(repository) as T
    }

}