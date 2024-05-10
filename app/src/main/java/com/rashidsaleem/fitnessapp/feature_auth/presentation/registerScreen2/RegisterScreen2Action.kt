package com.rashidsaleem.fitnessapp.feature_auth.presentation.registerScreen2

import com.rashidsaleem.fitnessapp.core.common.enums.GenderEnum
import java.util.Date

sealed class RegisterScreen2Action {
    data class ShowGenderMenu(val value: Boolean): RegisterScreen2Action()
    data class ShowDateOfBirthDatePicker(val value: Boolean): RegisterScreen2Action()
    data class SetGender(val value: GenderEnum): RegisterScreen2Action()
    data class SetDateOfBirth(val value: Date): RegisterScreen2Action()
    data class SetWeight(val value: String): RegisterScreen2Action()
    data class SetHeight(val value: String): RegisterScreen2Action()
    data object NextOnClick: RegisterScreen2Action()

}