package com.example.prueba_desconecta.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.prueba_desconecta.repository.MuseuContentDBRepository

class ViewModelFactory(private val repository: MuseuContentDBRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ViewModelPrueba(repository) as T
    }
}