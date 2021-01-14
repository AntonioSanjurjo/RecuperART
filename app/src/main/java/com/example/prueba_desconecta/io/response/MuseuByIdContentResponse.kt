package com.example.prueba_desconecta.io.response

import com.example.prueba_desconecta.io.model.Museo

data class MuseuByIdContentResponse(
    val err: Boolean,
    val status: Int,
    val version: Int,
    val ans: Museo
)