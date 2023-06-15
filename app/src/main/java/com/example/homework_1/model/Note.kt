package com.example.homework_1.model

import java.util.Date

data class Note (
    val id: Long,
    val userEmail: String,
    val title: String,
    var message: String,
    val date: Long,
)
