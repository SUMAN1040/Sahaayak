/*
 * Name: Suman Kumar Dey
 * Info: Built a women safety app “SafeCircle” in Kotlin + XML integrating sensor data, mic audio, and an on-device ML model to detect real-time danger. Auto-triggers SMS, location sharing, and alarm on risk detection. Showcased advanced Android and edge ML integration.
 * Connect with me: www.linkedin.com/in/suman1040
 */

package com.example.sahaayak.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sahaayak.data.repository.AuthRepository
import com.example.sahaayak.databinding.ActivitySignInBinding
import com.example.sahaayak.domain.AuthUseCase
import com.example.sahaayak.ui.activities.MainActivity
import com.example.sahaayak.ui.viewmodel.AuthViewModel
import com.google.firebase.auth.FirebaseAuth

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    private lateinit var viewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = AuthRepository(FirebaseAuth.getInstance())
        val useCase = AuthUseCase(repository)
        viewModel = AuthViewModel(useCase)

        binding.signInBtn.setOnClickListener {
            val email = binding.emailEt.text.toString()
            val pass = binding.passEt.text.toString()

            viewModel.login(email, pass)
        }


        viewModel.authResult.observe(this) { result ->
            result.onSuccess {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
            result.onFailure {
                Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
            }
        }

        binding.goToSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

    }
}