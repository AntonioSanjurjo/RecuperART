package com.example.prueba_desconecta.common

import android.app.Application
import io.reactivex.internal.util.AppendOnlyLinkedArrayList

class MyApp: Application() {
    companion object{
        lateinit var  instance: MyApp
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}