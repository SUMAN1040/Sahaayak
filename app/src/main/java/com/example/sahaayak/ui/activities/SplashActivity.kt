package com.example.sahaayak.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.sahaayak.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)

        window.decorView.postDelayed({
            startActivity(Intent(this, OnboardingActivity::class.java)) // or MainActivity
            finish()
        }, 3000)
    }
}