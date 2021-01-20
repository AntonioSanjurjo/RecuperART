package com.example.recuperart.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.recuperart.repository.MediaObraRepository

class ViewModelMedIaObraFactory(private val repository: MediaObraRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ViewModelMediaObra(repository) as T
    }

}