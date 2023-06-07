package com.example.homework_1

import android.app.Application
import com.example.homework_1.db.DataBaseModule
import com.example.homework_1.repositories.SharedPreferenceRepository
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {

//    override fun onCreate() {
//        super.onCreate()
//        SharedPreferenceRepository.init(applicationContext)
//        DataBaseModule.initDb(applicationContext)
//    }
}