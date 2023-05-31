package com.example.homework_1.repositories

import com.example.homework_1.db.DataBase
import com.example.homework_1.model.User
import com.example.homework_1.model.entity.UserEntity

class UserRepository {

    fun getUsers(): ArrayList<User> {
        return (DataBase.userDao?.getAllNotes()?.map {
            User(
                it.firstName,
                it.secondName,
                it.userEmail,
                it.userEmailPassword
            )
        } as? ArrayList<User>) ?: arrayListOf()
    }

    fun addUser(user: User): Boolean {
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

    fun removeUser(user: User) {
        DataBase.listOfUsers.remove(user)
    }

}
