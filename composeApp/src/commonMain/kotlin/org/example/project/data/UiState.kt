package org.example.project.data

data class UiState(
    val loggerIn: Boolean = false,
    val username: String? = null,
    val password: String? = null,
    val isLoading: Boolean = false,
    val errorMessages: String? = null
)
