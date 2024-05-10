package com.rashidsaleem.fitnessapp.feature_auth.domain.useCase

import android.util.Patterns
import com.rashidsaleem.fitnessapp.core.common.enums.GenderEnum

class ValidateGender {

    fun execute(value: GenderEnum?): ValidationResult {
        val errorMessage = when {
            (value == null) -> "Please select Gender."
            else -> null
        }
        return if (errorMessage == null)
            ValidationResult(true)
        else
            ValidationResult(
                successful = false,
                errorMessage = errorMessage,
            )
    }
}