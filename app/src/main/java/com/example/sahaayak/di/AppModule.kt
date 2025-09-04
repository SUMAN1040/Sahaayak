/*
 * Name: Suman Kumar Dey
 * Info: Built a women safety app “SafeCircle” in Kotlin + XML integrating sensor data, mic audio, and an on-device ML model to detect real-time danger. Auto-triggers SMS, location sharing, and alarm on risk detection. Showcased advanced Android and edge ML integration.
 * Connect with me: www.linkedin.com/in/suman1040
 */

package com.example.sahaayak.di

import com.example.sahaayak.data.repository.AuthRepository
import com.example.sahaayak.domain.AuthUseCase
import com.example.sahaayak.ui.viewmodel.AuthViewModel
import com.google.firebase.auth.FirebaseAuth

object AppModule {

    private val firebaseAuth: FirebaseAuth by lazy { FirebaseAuth.getInstance() }
    private val authRepository: AuthRepository by lazy { AuthRepository(firebaseAuth) }
    private val authUseCase: AuthUseCase by lazy { AuthUseCase(authRepository) }

    fun provideAuthViewModel(): AuthViewModel {
        return AuthViewModel(authUseCase)
    }
}
