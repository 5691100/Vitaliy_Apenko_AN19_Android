package com.example.homework_1.util

import com.example.homework_1.model.User
import com.example.homework_1.model.entity.UserEntity

fun User.toUserEntity(): UserEntity =
    UserEntity(
        firstName,
        secondName,
        userEmail,
        userEmailPassword
    )

fun UserEntity.toUser(): User =
    User(
        firstName,
        secondName,
        userEmail,
        userEmailPassword
    )

fun List<UserEntity>.toListUser(): ArrayList<User> =
    (map {
        it.toUser()
    } as? ArrayList<User>) ?: arrayListOf()