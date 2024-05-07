package com.rashidsaleem.fitnessapp.feature_auth.presentation.registerScreen2

import com.rashidsaleem.fitnessapp.core.common.enums.GenderEnum
import java.util.Date

data class RegisterScreen2UiState(
    val genderEnum: GenderEnum? = null,
    val dateOfBirth: Date? = null,
    val weight: Float = 0.0f,
    val height: Float = 0.0f,
    val showGenderMenu: Boolean = false,
    val showDateOfBirthDatePicker: Boolean = false,
)
