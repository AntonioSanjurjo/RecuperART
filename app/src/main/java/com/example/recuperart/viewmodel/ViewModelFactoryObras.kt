package com.example.recuperart.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.recuperart.repository.ObrasRepository

class ViewModelFactoryObras (private val repository: ObrasRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ViewModelObras(repository) as T
    }
}