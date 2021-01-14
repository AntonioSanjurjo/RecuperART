package com.example.prueba_desconecta.repository

import androidx.lifecycle.LiveData
import com.example.prueba_desconecta.data.Experience
import com.example.prueba_desconecta.data.ExperienceDao

class ExperienceRepository( private val experienceDao: ExperienceDao) {

    var readAllData: LiveData<List<Experience>> = experienceDao.readAllData()

    suspend fun addExperience(experience: Experience){
        experienceDao.addExperience(experience)
    }
}