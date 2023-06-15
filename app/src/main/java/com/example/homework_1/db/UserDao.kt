package com.example.homework_1.db

import androidx.room.*
import com.example.homework_1.model.User
import com.example.homework_1.model.entity.UserEntity

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)

    @Delete
    suspend fun deleteUser(user: UserEntity)

    @Query("SELECT * FROM user")
    suspend fun getAllUsers(): List<UserEntity>

    @Query("SELECT * FROM user WHERE userEmail=(:userEmail)")
    suspend fun getUser(userEmail: String): UserEntity?
}