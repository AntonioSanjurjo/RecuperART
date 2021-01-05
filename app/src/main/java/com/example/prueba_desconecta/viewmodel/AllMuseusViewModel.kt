package com.example.prueba_desconecta.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.prueba_desconecta.repository.AllMuseusDBRepository
import com.example.prueba_desconecta.io.model.PreviewMuseo

class AllMuseusViewModel: ViewModel() {
    private var allMuseusDBRepository : AllMuseusDBRepository
    private var allMuseus : LiveData<ArrayList<PreviewMuseo>>

    init {
        allMuseusDBRepository = AllMuseusDBRepository()
        allMuseus = allMuseusDBRepository?.callallmuseus()!!
    }

    fun getAllMuseus(): LiveData<ArrayList<PreviewMuseo>>{
        return allMuseus
    }
}
