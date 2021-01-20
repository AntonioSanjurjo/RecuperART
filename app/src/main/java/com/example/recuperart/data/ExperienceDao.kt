package com.example.recuperart.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ExperienceDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addExperience(experience: Experience)

    @Query("SELECT * FROM experience_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Experience>>
}