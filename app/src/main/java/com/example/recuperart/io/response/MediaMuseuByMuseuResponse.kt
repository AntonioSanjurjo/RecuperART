package com.example.recuperart.io.response

import com.example.recuperart.io.model.Media

data class MediaMuseuByMuseuResponse (
    var err: Boolean,
    var status: Int,
    var version: Int,
    var ans : ArrayList<Media>
)
