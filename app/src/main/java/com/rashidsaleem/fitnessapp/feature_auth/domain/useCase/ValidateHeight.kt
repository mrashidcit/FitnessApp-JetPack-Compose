package com.rashidsaleem.fitnessapp.feature_auth.domain.useCase

class ValidateHeight {

    fun execute(value: String): ValidationResult {
        val errorMessage = when {
            (value.isEmpty()) -> "Please enter your height"
            else -> null
        }
        return if (errorMessage == null) {
            ValidationResult(true)
        } else {
            ValidationResult(
                successful = false,
                errorMessage = errorMessage,
            )
        }
    }
}