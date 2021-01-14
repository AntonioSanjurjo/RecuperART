package com.example.prueba_desconecta.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.prueba_desconecta.data.Experience
import com.example.prueba_desconecta.data.ExperienceDatabase
import com.example.prueba_desconecta.repository.ExperienceRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ExperienceViewModel(application: Application): AndroidViewModel(application) {

    private val readAllData: LiveData<List<Experience>>
    private val repository: ExperienceRepository
    init{
        val experienceDao = ExperienceDatabase.getDatabase(application).experienceDao()
        repository = ExperienceRepository(experienceDao)
        readAllData = repository.readAllData
    }

    fun addExperience(experience: Experience){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addExperience(experience)
        }
    }
}