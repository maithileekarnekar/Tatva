package com.androidwavelength.tatva.auth.repository

import com.androidwavelength.tatva.db.User
import com.androidwavelength.tatva.db.UserDao

class AuthRepository(private val userDao: UserDao) {

    suspend fun registerUser(user: User) {
        userDao.insertUser(user) // suspend function
    }

    suspend fun getUserByEmail(email: String): User? {
        return userDao.getUserByEmail(email) // suspend function
    }
}