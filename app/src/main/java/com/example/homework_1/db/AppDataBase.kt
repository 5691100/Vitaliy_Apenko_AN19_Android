package com.example.homework_1.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.homework_1.model.entity.NoteEntity
import com.example.homework_1.model.entity.UserEntity
import com.example.homework_1.util.TypeConverter

@Database(entities = [NoteEntity::class, UserEntity::class], version = 1)
@TypeConverters(TypeConverter::class)
abstract class AppDataBase: RoomDatabase() {

    abstract fun getNoteDao(): NoteDao

    abstract fun getUserDao(): UserDao
}