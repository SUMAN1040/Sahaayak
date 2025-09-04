/*
 * Name: Suman Kumar Dey
 * Info: Built a women safety app “SafeCircle” in Kotlin + XML integrating sensor data, mic audio, and an on-device ML model to detect real-time danger. Auto-triggers SMS, location sharing, and alarm on risk detection. Showcased advanced Android and edge ML integration.
 * Connect with me: www.linkedin.com/in/suman1040
 */

package com.example.sahaayak.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sahaayak.domain.AuthUseCase
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.launch

class AuthViewModel(private val useCase: AuthUseCase) : ViewModel() {

    private val _authResult = MutableLiveData<Result<AuthResult>>()
    val authResult: LiveData<Result<AuthResult>> = _authResult

    fun register(email: String, password: String) {
        viewModelScope.launch {
            val result = useCase.register(email, password)
            _authResult.postValue(result)
        }
    }

    fun login(email: String, password: String) {
        viewModelScope.launch {
            val result = useCase.login(email, password)
            _authResult.postValue(result)
        }
    }
}
