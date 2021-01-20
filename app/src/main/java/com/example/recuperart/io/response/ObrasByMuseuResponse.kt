package com.example.recuperart.io.response

import com.example.recuperart.io.model.Obra

data class ObrasByMuseuResponse(
    var err: Boolean,
    var status: Int,
    var version: Int,
    var ans: ArrayList<Obra>
)