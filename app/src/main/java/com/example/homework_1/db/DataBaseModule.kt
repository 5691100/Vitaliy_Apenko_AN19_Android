package com.example.homework_1.db

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

//    private var dataBase: AppDataBase ?= null
//
//    var noteDao: NoteDao ?= null
//    var userDao: UserDao ?= null
//
//    fun initDb (context: Context) {
//        dataBase = Room.databaseBuilder(context, AppDataBase::class.java, "data-base")
//            .build()
//        noteDao = dataBase?.getNoteDao()
//        userDao = dataBase?.getUserDao()
//    }

    @Provides
    @Singleton
    fun provideNoteDao (@ApplicationContext context: Context): NoteDao {
        return Room.databaseBuilder(context, AppDataBase::class.java, "data-base")
            .build().getNoteDao()
    }

    @Provides
    @Singleton
    fun provideUserDao (@ApplicationContext context: Context): UserDao {
        return Room.databaseBuilder(context, AppDataBase::class.java, "data-base")
            .build().getUserDao()
    }

}