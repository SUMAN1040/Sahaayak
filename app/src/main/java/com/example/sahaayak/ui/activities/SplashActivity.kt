/*
 * Name: Suman Kumar Dey
 * Info: Built a women safety app “SafeCircle” in Kotlin + XML integrating sensor data, mic audio, and an on-device ML model to detect real-time danger. Auto-triggers SMS, location sharing, and alarm on risk detection. Showcased advanced Android and edge ML integration.
 * Connect with me: www.linkedin.com/in/suman1040
 */

package com.example.sahaayak.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.sahaayak.R
import com.example.sahaayak.auth.SignInActivity
import com.google.firebase.auth.FirebaseAuth

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)

        val currentUser = FirebaseAuth.getInstance().currentUser

        window.decorView.postDelayed({
            if (currentUser != null) {
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                startActivity(Intent(this, SignInActivity::class.java))
            }
            finish()
        }, 3000)
    }
}
