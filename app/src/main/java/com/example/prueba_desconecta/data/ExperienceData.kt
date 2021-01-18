package com.example.prueba_desconecta.data

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.widget.ImageView


class ExperienceData {
    companion object {
        var nom_museo: String = "Museu no especificat"
        var nom_obra: String = "Obra no especificada"
        var colorstart: String = "#00000"
        lateinit var workcloud: Bitmap
        var cancion: String = ""
        lateinit var dibujo: Bitmap
        var escribe: String = ""
        var revisita: String = ""
        var colorend: String = "#00000"
    }
}