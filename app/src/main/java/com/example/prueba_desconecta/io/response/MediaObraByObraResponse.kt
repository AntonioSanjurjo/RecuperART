package com.example.prueba_desconecta.io.response

import com.example.prueba_desconecta.io.model.Media

data class MediaObraByObraResponse(
    var err: Boolean,
    var status: Int,
    var version: Int,
    var ans : ArrayList<Media>
)
