package com.orangeman.example.survey.config.authenticate.model

data class LoginRequest(
    val username: String,
    val password: String
) {
    fun isValid() = username.isNullOrBlank() || password.isNullOrBlank()
}
