package com.androidwavelength.tatva.auth.views

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.androidwavelength.tatva.auth.viewmodel.AuthViewModel
import com.androidwavelength.tatva.databinding.ActivityRegisterBinding
import com.androidwavelength.tatva.db.User

class RegisterActivity :AppCompatActivity() {
    private lateinit var activityRegisterBinding: ActivityRegisterBinding
    private lateinit var authViewModel :AuthViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize View Binding
        activityRegisterBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(activityRegisterBinding.root)

    }
    private fun setupClickListeners() {
        activityRegisterBinding.btnRegister.setOnClickListener {
            val name = activityRegisterBinding.edtName.text.toString()
            val email = activityRegisterBinding.edtEmail.text.toString()
            val password = activityRegisterBinding.edtPassword.text.toString()

            if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                val user = User(name = name, email = email, password = password)
                authViewModel.registerUser(user)
                Toast.makeText(this, "Registration Successful!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, WelcomeActivity::class.java))
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }

        activityRegisterBinding.imgGoogleIcon.setOnClickListener {
            activityRegisterBinding.signInWithGoogle(this)
        }

        activityRegisterBinding.imgFacebookIcon.setOnClickListener {
            authViewModel.signInWithFacebook(this)
        }

        activityRegisterBinding.imgTwitterIcon.setOnClickListener {
            authViewModel.signInWithTwitter(this)
        }
    }
}
}