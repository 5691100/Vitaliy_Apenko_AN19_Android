package com.example.homework_1.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(
    @ColumnInfo("firstName")
    val firstName: String,
    @ColumnInfo("secondName")
    val secondName: String,
    @PrimaryKey
    @ColumnInfo("userEmail")
    val userEmail: String,
    @ColumnInfo("userEmailPassword")
    val userEmailPassword: String
)