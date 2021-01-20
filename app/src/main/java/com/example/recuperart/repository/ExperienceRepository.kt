package com.example.recuperart.repository

import androidx.lifecycle.LiveData
import com.example.recuperart.data.Experience
import com.example.recuperart.data.ExperienceDao

class ExperienceRepository( private val experienceDao: ExperienceDao) {

    var readAllData: LiveData<List<Experience>> = experienceDao.readAllData()

    suspend fun addExperience(experience: Experience){
        experienceDao.addExperience(experience)
    }
}