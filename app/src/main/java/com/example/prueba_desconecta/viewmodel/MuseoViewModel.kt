package com.example.prueba_desconecta.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.prueba_desconecta.repository.MuseuDBRepository
import com.example.prueba_desconecta.ui.Museo
import com.example.prueba_desconecta.ui.Obra

class MuseoViewModel: ViewModel() {
    private var museuContentDBRepository: MuseuDBRepository
    private var museu: Museo
    private var allObras: MutableLiveData<ArrayList<Obra>>

    init {
        museuContentDBRepository = MuseuDBRepository()
        museu = museuContentDBRepository?.museo!!
        allObras = museuContentDBRepository?.allObras!!
    }

    fun getMuseuContent(): Museo{ return museu }

    fun getallObras(): MutableLiveData<ArrayList<Obra>>{ return allObras }
}