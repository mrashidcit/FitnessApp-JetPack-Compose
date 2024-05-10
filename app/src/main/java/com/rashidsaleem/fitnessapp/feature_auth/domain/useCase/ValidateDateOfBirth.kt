package com.rashidsaleem.fitnessapp.feature_auth.domain.useCase

import java.util.Date

class ValidateDateOfBirth {

    fun execute(value: Date?): ValidationResult {
        val errorMessage = when {
            (value == null) -> "Please enter Date of Birth"
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