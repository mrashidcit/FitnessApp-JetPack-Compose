package com.rashidsaleem.fitnessapp.feature_auth.presentation.registerScreen2

import com.rashidsaleem.fitnessapp.core.common.enums.GenderEnum
import java.util.Date

data class RegisterScreen2UiState(
    val gender: GenderEnum? = null,
    val dateOfBirth: Date? = null,
    val weight: String = "",
    val height: String = "",
    val showGenderMenu: Boolean = false,
    val showDateOfBirthDatePicker: Boolean = false,
    val validationErrorMessage: String? = null,
) {
    fun getGenderLabel() : String {
        if (gender == null) return "Choose Gender"
        return gender.name
    }
}

val previewRegisterScreen2UiState = RegisterScreen2UiState()
