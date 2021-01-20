package com.example.recuperart.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Experience::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class ExperienceDatabase: RoomDatabase() {

    abstract fun experienceDao(): ExperienceDao

    companion object{
        @Volatile
        private var INSTANCE: ExperienceDatabase? = null

        fun getDatabase(context: Context): ExperienceDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,
                    ExperienceDatabase::class.java,
                    "experience_database"
                ).build()
                INSTANCE= instance
                return instance
            }
        }

    }
}