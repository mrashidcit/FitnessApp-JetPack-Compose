package com.rashidsaleem.fitnessapp.feature_auth.domain.useCase

class ValidatePolicyAndTerms {
    fun execute(value: Boolean) : ValidationResult {
        if (!value) {
            return ValidationResult(
                successful = false,
                errorMessage = "Please Accept Policy and Terms of Use."
            )
        }

        return ValidationResult(
            successful = true
        )
    }
}