package com.rashidsaleem.fitnessapp.feature_auth.presentation.registerScreen2

import com.rashidsaleem.fitnessapp.core.common.enums.GenderEnum
import java.util.Date

sealed class RegisterScreen2Action {
    data class ShowGenderMenu(val value: Boolean): RegisterScreen2Action()
    data class ShowDateOfBirthDatePicker(val value: Boolean): RegisterScreen2Action()

    data class NextOnClick(
        val gender: GenderEnum,
        val dateOfBirth: Date,
        val weight: Float,
        val height: Float,
    ): RegisterScreen2Action()
}