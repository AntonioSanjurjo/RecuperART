package com.example.prueba_desconecta.io.response

import com.example.prueba_desconecta.io.model.Obra

data class ObrasByMuseuResponse(
    var err: Boolean,
    var status: Int,
    var version: Int,
    var ans: ArrayList<Obra>
)