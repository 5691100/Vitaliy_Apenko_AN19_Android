package com.example.homework_1.repositories

import com.example.homework_1.db.UserDao
import com.example.homework_1.model.User
import com.example.homework_1.util.toUser
import com.example.homework_1.util.toUserEntity
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userDao: UserDao
) {

//    suspend fun getAllUsers(): ArrayList<User> {
//        return (userDao.getAllUsers().toListUser())
//    }

    suspend fun getUser(email: String): User? {
        val userEntity = userDao.getUser(email)
        return if (userEntity != null) {
            userEntity.toUser()
        } else {
            null
        }
    }

    suspend fun addUser(user: User): Boolean {
        userDao.insertUser(user.toUserEntity())
        return true
    }

    suspend fun removeUser(user: User) {
        userDao.deleteUser(user.toUserEntity())
    }
}
