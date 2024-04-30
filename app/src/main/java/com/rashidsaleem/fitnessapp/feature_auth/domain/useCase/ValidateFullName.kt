package com.rashidsaleem.fitnessapp.feature_auth.domain.useCase

class ValidateFullName {

    fun execute(fullName: String): ValidationResult {
        if (fullName.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "Full name can't be blank"
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}