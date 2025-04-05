package com.androidwavelength.tatva.auth.viewmodel

import android.app.Activity
import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidwavelength.tatva.auth.repository.AuthRepository
import com.androidwavelength.tatva.db.User
import kotlinx.coroutines.launch


class AuthViewModel(private val authRepository: AuthRepository) : ViewModel() {

    private val _loginResult = MutableLiveData<User?>()
    val loginResult: LiveData<User?> get() = _loginResult

    private val _registerResult = MutableLiveData<Boolean>()
    val registerResult: LiveData<Boolean> get() = _registerResult

    // ✅ Email & Password Login
    fun loginUser(email: String, password: String): LiveData<User?> {
        viewModelScope.launch {
            val user = authRepository.getUserByEmail(email)
            if (user?.password == password) {
                _loginResult.postValue(user)
            } else {
                _loginResult.postValue(null)
            }
        }
        return loginResult
    }

    // ✅ Register User in Room Database
    fun registerUser(user: User) {
        viewModelScope.launch {
            authRepository.insertUser(user)
            _registerResult.postValue(true)
        }
    }

    // ✅ Sign in with Google
    fun signInWithGoogle(activity: Activity) {
        authRepository.googleSignIn(activity)
    }

    // ✅ Handle Google Login Callback
    fun loginWithGoogle(requestCode: Int, data: Intent?, onSuccess: (User) -> Unit, onFailure: () -> Unit) {
        authRepository.handleGoogleSignIn(requestCode, data, onSuccess, onFailure)
    }

    // ✅ Sign in with Facebook
    fun signInWithFacebook(activity: Activity) {
        authRepository.facebookSignIn(activity)
    }

    // ✅ Handle Facebook Login Callback
    fun loginWithFacebook(requestCode: Int, resultCode: Int, data: Intent?, onSuccess: (User) -> Unit, onFailure: () -> Unit) {
        authRepository.handleFacebookSignIn(requestCode, resultCode, data, onSuccess, onFailure)
    }

    // ✅ Sign in with Twitter (X)
    fun signInWithTwitter(activity: Activity) {
        authRepository.twitterSignIn(activity)
    }

    // ✅ Handle Twitter Login Callback
    fun loginWithTwitter(requestCode: Int, resultCode: Int, data: Intent?, onSuccess: (User) -> Unit, onFailure: () -> Unit) {
        authRepository.handleTwitterSignIn(requestCode, resultCode, data, onSuccess, onFailure)
    }
}