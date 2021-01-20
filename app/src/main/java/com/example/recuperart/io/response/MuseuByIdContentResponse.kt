package com.example.recuperart.io.response

import com.example.recuperart.io.model.Museo

data class MuseuByIdContentResponse(
    val err: Boolean,
    val status: Int,
    val version: Int,
    val ans: Museo
)