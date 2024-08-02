package com.rashidsaleem.fitnessapp.feature_auth.domain.useCase

import com.rashidsaleem.fitnessapp.R
import com.rashidsaleem.fitnessapp.core.common.enums.GenderEnum
import com.rashidsaleem.fitnessapp.core.common.util.ResourceProvider

class ValidateGenderUseCase(
    private val resourceProvider: ResourceProvider,
) {

    fun execute(value: GenderEnum?): ValidationResult {
        val errorMessage = when {
            (value == null) ->  resourceProvider.getString(R.string.please_select_gender)
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