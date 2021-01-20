package com.example.recuperart.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.recuperart.repository.MuseuContentDBRepository

class ViewModelFactory(private val repository: MuseuContentDBRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ViewModelPrueba(repository) as T
    }
}