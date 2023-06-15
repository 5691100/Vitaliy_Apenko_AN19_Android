package com.example.homework_1.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.homework_1.model.entity.NoteEntity
import com.example.homework_1.model.entity.UserEntity

@Database(entities = [NoteEntity::class, UserEntity::class], version = 1)
abstract class AppDataBase: RoomDatabase() {

    abstract fun getNoteDao(): NoteDao

    abstract fun getUserDao(): UserDao
}