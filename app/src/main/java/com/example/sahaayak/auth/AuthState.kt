/*
 * Name: Suman Kumar Dey
 * Info: Built a women safety app “SafeCircle” in Kotlin + XML integrating sensor data, mic audio, and an on-device ML model to detect real-time danger. Auto-triggers SMS, location sharing, and alarm on risk detection. Showcased advanced Android and edge ML integration.
 * Connect with me: www.linkedin.com/in/suman1040
 */

package com.example.sahaayak.auth

sealed class AuthState {
    object Idle : AuthState()
    object Loading : AuthState()
    data class Success(val message: String = "Success") : AuthState()
    data class Error(val error: String) : AuthState()
}