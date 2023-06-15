package com.example.homework_1.db

import android.content.Context
import androidx.room.Room
import com.example.homework_1.model.Note
import com.example.homework_1.model.User

object DataBase {

    private var dataBase: AppDataBase ?= null

    var noteDao: NoteDao ?= null
    var userDao: UserDao ?= null

    fun initDb (context: Context) {
        dataBase = Room.databaseBuilder(context, AppDataBase::class.java, "data-base")
            .allowMainThreadQueries()
            .build()
        noteDao = dataBase?.getNoteDao()
        userDao = dataBase?.getUserDao()
    }

    val listOfNotes = arrayListOf<Note>()

    val listOfUsers = arrayListOf<User>()

}