package com.example.prueba_desconecta.io.model

data class Museo(
    var id: Int,
    var nom: String,
    var direccio: String,
    var descripcio: String,
    var tipus: TipusMuseu,
    var obres: ArrayList<PreviewObra>

)