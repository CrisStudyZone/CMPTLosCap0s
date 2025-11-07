package org.example.project.ui.screen.login.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import org.example.project.data.UiState

class LoginViewModel : ViewModel() {

    var state by mutableStateOf(UiState())
    private set

    fun login(username: String, password: String) {
        state = when {
            username.contains('@') -> UiState(errorMessages = "Invalid Username")
            password.length < 8 -> UiState(errorMessages = "Invalid Password")
            else -> UiState(loggerIn = true, errorMessages = null)
        }
    }
}