package com.rashidsaleem.fitnessapp.feature_auth.domain.useCase

class ValidatePassword {
    fun execute(value: String): ValidationResult {
        if (value.length < 8) {
            return ValidationResult(
                successful = false,
                errorMessage = "The password length should be at least 8 characters"
            )
        }
        val containsLettersAndDigits = value.any { it.isDigit() } && value.any { it.isLetter() }
        if (!containsLettersAndDigits) {
            return ValidationResult(
                successful = false,
                errorMessage = "The password should contains at least one letter and digit"
            )
        }
        return ValidationResult(true)
    }
}