package com.example.recuperart.data

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "experience_table")
data class Experience(
    val nom_museo: String,
    val nom_obra: String,
    val colorstart: String,
    val workcloud: Bitmap,
    val cancion: String,
    val dibujo: Bitmap,
    val escribe: String,
    val revisita: String,
    val colorend: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}

