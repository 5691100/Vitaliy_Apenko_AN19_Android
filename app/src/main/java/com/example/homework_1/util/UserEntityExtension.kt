package com.example.homework_1.util

import com.example.homework_1.model.Note
import com.example.homework_1.model.User
import com.example.homework_1.model.entity.NoteEntity
import com.example.homework_1.model.entity.UserEntity

fun getUserFromEntity(entity: UserEntity): User {
    return User(
        entity.firstName,
        entity.secondName,
        entity.userEmail,
        entity.userEmailPassword
    )
}

fun getNoteFromEntity(entity: NoteEntity): Note {
    return Note(
        entity.id,
        entity.userEmail,
        entity.title,
        entity.message,
        entity.date
    )
}