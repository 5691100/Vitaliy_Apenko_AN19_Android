package com.example.homework_1.repositories

import com.example.homework_1.db.DataBase
import com.example.homework_1.model.User
import com.example.homework_1.model.entity.UserEntity

class UserRepository {

    suspend fun getAllUsers(): ArrayList<User> {
        return (DataBase.userDao?.getAllUsers()?.map {
            User(
                it.firstName,
                it.secondName,
                it.userEmail,
                it.userEmailPassword
            )
        } as? ArrayList<User>) ?: arrayListOf()
    }

    suspend fun getUser(email: String): User? = DataBase.userDao?.getUser(email)

    suspend fun addUser(user: User): Boolean {
        DataBase.userDao?.insertUser(
            UserEntity(
                user.firstName,
                user.secondName,
                user.userEmail,
                user.userEmailPassword
            )
        )
        return true
    }

    suspend fun removeUser(user: User) {
        DataBase.userDao?.deleteUser(
            UserEntity(
                user.firstName,
                user.secondName,
                user.userEmail,
                user.userEmailPassword
            )
        )
    }
}
