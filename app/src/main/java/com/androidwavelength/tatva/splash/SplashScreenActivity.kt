package com.androidwavelength.tatva.splash

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.androidwavelength.tatva.R
import com.androidwavelength.tatva.auth.ui.WelcomeActivity
import com.androidwavelength.tatva.databinding.ActivitySplashscreenBinding

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity :AppCompatActivity() {
    private lateinit var activitySplashscreenBinding: ActivitySplashscreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize View Binding
        activitySplashscreenBinding = ActivitySplashscreenBinding.inflate(layoutInflater)
        setContentView(activitySplashscreenBinding.root)

        animateImageView()
        navigateToWelcomeActivity()
    }

    private fun animateImageView() {
        // Load fade-in animation
        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)

        // Apply fade-in animation
        activitySplashscreenBinding.imgAppIcon.startAnimation(fadeIn)
    }

    private fun navigateToWelcomeActivity() {

        // Delay for 2 seconds, then move to WelcomeActivity
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)
            finish() // Close SplashScreenActivity
        }, 2000) // 2000ms = 2 seconds
    }

}