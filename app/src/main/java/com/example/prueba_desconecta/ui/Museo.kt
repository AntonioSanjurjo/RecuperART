package com.example.prueba_desconecta.ui

data class Museo(
    var id: Int,
    var nom: String,
    var direccio: String,
    var descripcio: String,
    var tipus: TipusMuseu2,
    var obres: ArrayList<PreviewObra>

)