package com.example.recuperart.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.recuperart.data.Experience
import com.example.recuperart.data.ExperienceDatabase
import com.example.recuperart.repository.ExperienceRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ExperienceViewModel(application: Application): AndroidViewModel(application) {

     val readAllData: LiveData<List<Experience>>
     val repository: ExperienceRepository
    
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