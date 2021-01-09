package com.example.prueba_desconecta.io.response

import com.example.prueba_desconecta.ui.Museo

data class MuseuByIdContentResponse2(
    val err: Boolean,
    val status: Int,
    val version: Int,
    val ans: Museo
)