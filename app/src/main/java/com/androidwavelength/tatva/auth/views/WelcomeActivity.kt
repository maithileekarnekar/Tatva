package com.androidwavelength.tatva.auth.views

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.androidwavelength.tatva.auth.viewmodel.AuthViewModel
import com.androidwavelength.tatva.databinding.ActivityWelcomeBinding

class WelcomeActivity:AppCompatActivity() {
    private lateinit var activityWelcomeBinding: ActivityWelcomeBinding
    private lateinit var authViewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize View Binding
        activityWelcomeBinding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(activityWelcomeBinding.root)

        setupListeners()
    }

    private fun setupListeners() {

        activityWelcomeBinding.btnLogin.setOnClickListener {
            val email = activityWelcomeBinding.edtEmail.text.toString()
            val password = activityWelcomeBinding.edtPassword.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                authViewModel.loginUser(email, password).observe(this) { user ->
                    if (user != null) {
                        Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()
                        // Navigate to Home Screen
                    } else {
                        Toast.makeText(this, "Invalid Credentials!", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
            }
        }

        activityWelcomeBinding.txtNewUserRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        activityWelcomeBinding.imgGoogleIcon.setOnClickListener {
            authViewModel.signInWithGoogle(this)
        }

        activityWelcomeBinding.imgFacebookIcon.setOnClickListener {
            authViewModel.signInWithFacebook(this)
        }

        activityWelcomeBinding.imgFacebookIcon.setOnClickListener {
            authViewModel.signInWithTwitter(this)
        }
    }
    }
}