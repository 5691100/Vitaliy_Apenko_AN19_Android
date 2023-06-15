package com.example.homework_1.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo("userEmail")
    val userEmail: String,
    @ColumnInfo("title")
    val title: String,
    @ColumnInfo("message")
    val message: String,
    @ColumnInfo("date")
    val date: Long
)