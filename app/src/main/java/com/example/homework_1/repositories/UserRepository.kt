package com.example.homework_1.repositories

import com.example.homework_1.db.DataBaseModule
import com.example.homework_1.db.UserDao
import com.example.homework_1.model.User
import com.example.homework_1.model.entity.UserEntity
import com.example.homework_1.util.getUserFromEntity
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userDao: UserDao
) {

    suspend fun getAllUsers(): ArrayList<User> {
        return (userDao.getAllUsers()?.map {
            User(
                it.firstName,
                it.secondName,
                it.userEmail,
                it.userEmailPassword
            )
        } as? ArrayList<User>) ?: arrayListOf()
    }

    suspend fun getUser(email: String): User? {
        val userEntity = userDao.getUser(email)
        return if (userEntity != null) {
            getUserFromEntity(userEntity)
        } else {
            null
        }
    }

    suspend fun addUser(user: User): Boolean {
        userDao.insertUser(
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
        userDao.deleteUser(
            UserEntity(
                user.firstName,
                user.secondName,
                user.userEmail,
                user.userEmailPassword
            )
        )
    }
}
