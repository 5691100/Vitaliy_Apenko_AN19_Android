package com.example.homework_1

import android.app.Application
import com.example.homework_1.db.DataBase
import com.example.homework_1.repositories.SharedPreferenceRepository

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        SharedPreferenceRepository.init(applicationContext)
        DataBase.initDb(applicationContext)
    }
}