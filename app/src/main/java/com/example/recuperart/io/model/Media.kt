package com.example.recuperart.io.model

data class Media(
    var id: Int,
    var fileName: String,
    var fileSize: Long,
    var filePath: String,
    var fileType: String,
    var categoria: String
)