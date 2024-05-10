package com.rashidsaleem.fitnessapp.feature_auth.domain.useCase

class ValidateWeight {

    fun execute(value: String): ValidationResult {
        val errorMessage = when {
            (value.isEmpty()) -> "Please enter your weight"
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