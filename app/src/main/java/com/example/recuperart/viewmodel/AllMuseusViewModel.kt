package com.example.recuperart.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.recuperart.repository.AllMuseusDBRepository
import com.example.recuperart.io.model.PreviewMuseo

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
