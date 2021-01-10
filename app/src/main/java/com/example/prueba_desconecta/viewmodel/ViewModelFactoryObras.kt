package com.example.prueba_desconecta.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.prueba_desconecta.repository.ObrasRepository

class ViewModelFactoryObras (private val repository: ObrasRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ViewModelObras(repository) as T
    }
}