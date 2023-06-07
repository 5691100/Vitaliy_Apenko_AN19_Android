package com.example.homework_1.util

import com.example.homework_1.model.User
import com.example.homework_1.model.entity.UserEntity

fun getUserFromEntity(entity: UserEntity): User {
    return User(
        entity.firstName,
        entity.secondName,
        entity.userEmail,
        entity.userEmailPassword
    )
}