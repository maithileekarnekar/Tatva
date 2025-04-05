package com.androidwavelength.tatva.db

import android.content.Context
import com.androidwavelength.tatva.auth.viewmodel.AuthViewModel

object DbUtil {

    private var database: AppDatabase? = null

    fun provideAuthRepository(context: Context): AuthViewModel.AuthRepository {
        if (database == null) {
            database = AppDatabase.getInstance(context)
        }
        return AuthViewModel.AuthRepository(database!!.userDao())
    }
}