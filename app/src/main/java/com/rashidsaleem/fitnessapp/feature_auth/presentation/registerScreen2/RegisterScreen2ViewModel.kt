package com.rashidsaleem.fitnessapp.feature_auth.presentation.registerScreen2

import com.rashidsaleem.fitnessapp.core.common.Routes
import com.rashidsaleem.fitnessapp.core.common.enums.GenderEnum
import com.rashidsaleem.fitnessapp.core.presentation.baseScreen.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class RegisterScreen2ViewModel @Inject constructor(

) : BaseViewModel() {

    private val _uiState = MutableStateFlow(RegisterScreen2UiState())
    val uiState = _uiState.asStateFlow()

    private fun updateUiState(
        gender: GenderEnum? = null,
        dateOfBirth: Date? = null,
        weight: String? = null,
        height: String? = null,
        showGenderMenu: Boolean? = null,
        showDateOfBirthDatePicker: Boolean? = null,
    ) {
        _uiState.update {
            it.copy(
                gender = gender ?: it.gender,
                dateOfBirth = dateOfBirth ?: it.dateOfBirth,
                weight = weight ?: it.weight,
                height = height ?: it.height,
                showGenderMenu = showGenderMenu ?: it.showGenderMenu,
                showDateOfBirthDatePicker = showDateOfBirthDatePicker ?: it.showDateOfBirthDatePicker,
            )
        }

    }

    fun onAction(action: RegisterScreen2Action) {
        when (action) {
            is RegisterScreen2Action.ShowGenderMenu -> showGenderMenu(action.value)
            is RegisterScreen2Action.ShowDateOfBirthDatePicker -> showDateOfBirthDatePicker(action.value)
            is RegisterScreen2Action.NextOnClick -> nextOnClick(action)
            is RegisterScreen2Action.SetDateOfBirth -> setDateOfBirth(action.value)
            is RegisterScreen2Action.SetGender -> setGender(action.value)
            is RegisterScreen2Action.SetHeight -> setHeight(action.value)
            is RegisterScreen2Action.SetWeight -> setWeight(action.value)
        }
    }

    private fun showDateOfBirthDatePicker(value: Boolean) {
        updateUiState(
            showDateOfBirthDatePicker = value
        )
    }

    private fun setWeight(value: String) {
        updateUiState(
            weight = value
        )
    }

    private fun setHeight(value: String) {
        updateUiState(
            height = value
        )
    }

    private fun setGender(value: GenderEnum) {
        updateUiState(
            gender = value
        )
    }

    private fun setDateOfBirth(value: Date) {
        updateUiState(
            dateOfBirth = value
        )
    }

    private fun showGenderMenu(value: Boolean) {
        _uiState.update {
            it.copy(
                showGenderMenu = value
            )
        }
    }

    private fun showDateOfBirthDatePickerDialog(value: Boolean) {
        _uiState.update {
            it.copy(
                showDateOfBirthDatePicker = value
            )
        }
    }

    private fun nextOnClick(action: RegisterScreen2Action.NextOnClick) {



        navigateNext(Routes.REGISTER_SCREEN_3)
    }



}