package com.androidwavelength.tatva.auth.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.androidwavelength.tatva.databinding.ActivityRegisterBinding
import com.androidwavelength.tatva.databinding.ActivityWelcomeBinding

class RegisterActivity :AppCompatActivity() {
    private lateinit var activityRegisterBinding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize View Binding
        activityRegisterBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(activityRegisterBinding.root)

    }
}