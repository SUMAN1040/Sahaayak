package com.example.sahaayak.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sahaayak.data.repository.AuthRepository
import com.example.sahaayak.databinding.ActivitySignUpBinding
import com.example.sahaayak.domain.AuthUseCase
import com.example.sahaayak.ui.viewmodel.AuthViewModel
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var viewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = AuthRepository(FirebaseAuth.getInstance())
        val useCase = AuthUseCase(repository)
        viewModel = AuthViewModel(useCase)

        binding.signUpBtn.setOnClickListener {
            val name = binding.nameEt.text.toString()
            val email = binding.emailEt.text.toString()
            val phone = binding.phoneEt.text.toString()
            val pass = binding.passEt.text.toString()
            val confirmPass = binding.cpassEt.text.toString()

            if (name.isNotEmpty() && email.isNotEmpty() && phone.isNotEmpty() && pass.isNotEmpty()) {
                if (pass == confirmPass) {
                    viewModel.register(email, pass)
                } else {
                    Toast.makeText(this, "Passwords don’t match", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.authResult.observe(this) { result ->
            result.onSuccess {
                startActivity(Intent(this, SignInActivity::class.java))
                finish()
            }
            result.onFailure {
                Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
