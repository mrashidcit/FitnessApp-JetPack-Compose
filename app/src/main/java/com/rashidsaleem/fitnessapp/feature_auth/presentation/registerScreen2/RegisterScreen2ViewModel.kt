package com.rashidsaleem.fitnessapp.feature_auth.presentation.registerScreen2

import com.rashidsaleem.fitnessapp.R
import com.rashidsaleem.fitnessapp.core.common.Routes
import com.rashidsaleem.fitnessapp.core.common.enums.GenderEnum
import com.rashidsaleem.fitnessapp.core.common.util.ResourceProvider
import com.rashidsaleem.fitnessapp.core.presentation.baseScreen.BaseViewModel
import com.rashidsaleem.fitnessapp.feature_auth.domain.useCase.ValidateRegister2FormUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class RegisterScreen2ViewModel @Inject constructor(
    private val validateUseCase: ValidateRegister2FormUseCases,
    private val resourceProvider: ResourceProvider,
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

    private fun updateErrorMessage(message: String?) {
        _uiState.update {
            it.copy(
                validationErrorMessage = message
            )
        }
    }

    fun onAction(action: RegisterScreen2Action) {
        when (action) {
            is RegisterScreen2Action.ShowGenderMenu -> showGenderMenu(action.value)
            is RegisterScreen2Action.ShowDateOfBirthDatePicker -> showDateOfBirthDatePicker(action.value)
            is RegisterScreen2Action.NextOnClick -> nextOnClick()
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
        updateErrorMessage("")
    }

    private fun setWeight(value: String) {
        updateUiState(
            weight = value
        )
        updateErrorMessage("")

    }

    private fun setHeight(value: String) {
        updateUiState(
            height = value
        )
        updateErrorMessage("")
    }

    private fun setGender(value: GenderEnum) {
        updateUiState(
            gender = value
        )
        updateErrorMessage("")
    }

    private fun setDateOfBirth(value: Date) {
        updateUiState(
            dateOfBirth = value
        )
        updateErrorMessage("")
    }

    private fun showGenderMenu(value: Boolean) {
        _uiState.update {
            it.copy(
                showGenderMenu = value
            )
        }
        updateErrorMessage("")
    }

    private fun nextOnClick() {
        val genderValidationResult = validateUseCase.validateGenderUseCase.execute(uiState.value.gender)
        val dateOfBirthValidationResult = validateUseCase.validateDateOfBirth.execute(uiState.value.dateOfBirth)
        val weightValidationResult = validateUseCase.validateWeight.execute(uiState.value.weight)
        val heightValidationResult = validateUseCase.validateHeight.execute(uiState.value.height)

        val validationResults = listOf(
            genderValidationResult,
            dateOfBirthValidationResult,
            weightValidationResult,
            heightValidationResult
        )
        val isAllInputValid = validationResults.any { !it.successful }

        if (!isAllInputValid) {
            navigateNext(Routes.REGISTER_SCREEN_3)
            return
        }

        val errorMessage = resourceProvider.getString(R.string.please_fill_all_data)
        _uiState.update {
            it.copy(
                validationErrorMessage = errorMessage
            )
        }
    }



}