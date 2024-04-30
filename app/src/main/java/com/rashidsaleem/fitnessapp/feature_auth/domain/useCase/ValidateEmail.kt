package com.rashidsaleem.fitnessapp.feature_auth.domain.useCase

import android.util.Patterns

class ValidateEmail {

    fun execute(value: String): ValidationResult {
        val errorMessage = when {
            (value.isBlank()) -> "Please enter email address"
            (!Patterns.EMAIL_ADDRESS.matcher(value).matches()) -> "That's not a valid email"
            else -> null
        }
        return errorMessage?.let {
            ValidationResult(true)
        } ?: ValidationResult(
            successful = false,
            errorMessage = errorMessage
        )
    }
}