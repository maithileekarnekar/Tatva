package com.androidwavelength.tatva.auth.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.androidwavelength.tatva.databinding.ActivitySplashscreenBinding
import com.androidwavelength.tatva.databinding.ActivityWelcomeBinding

class WelcomeActivity:AppCompatActivity() {
    private lateinit var activityWelcomeBinding: ActivityWelcomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize View Binding
        activityWelcomeBinding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(activityWelcomeBinding.root)

        setupListeners()
    }

    private fun setupListeners() {
        activityWelcomeBinding.txtRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}