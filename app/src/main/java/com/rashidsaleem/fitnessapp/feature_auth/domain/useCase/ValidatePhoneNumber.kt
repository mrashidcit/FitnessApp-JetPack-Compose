package com.rashidsaleem.fitnessapp.feature_auth.domain.useCase

import android.util.Patterns

class ValidatePhoneNumber {

    fun execute(phoneNumber: String): ValidationResult {
        val errorMessage = when {
            (phoneNumber.isBlank()) -> "Phone Number can't be blank"
            (!Patterns.PHONE.matcher(phoneNumber).matches()) -> "That's not a valid Phone Number"
            else -> null
        }

        return if (errorMessage != null) {
            ValidationResult(
                successful = false,
                errorMessage = errorMessage
            )
        } else {
            ValidationResult(
                successful = true
            )
        }
    }
}