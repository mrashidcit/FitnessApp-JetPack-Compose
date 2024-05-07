package com.rashidsaleem.fitnessapp.feature_auth.presentation.registerScreen2

import com.rashidsaleem.fitnessapp.core.presentation.baseScreen.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class RegisterScreen2ViewModel @Inject constructor(

) : BaseViewModel() {

    private val _uiState = MutableStateFlow(RegisterScreen2UiState())
    val uiState = _uiState.asStateFlow()

    fun onAction(action: RegisterScreen2Action) {
        when (action) {
            is RegisterScreen2Action.ShowGenderMenu -> showGenderMenu(action.value)
            is RegisterScreen2Action.ShowDateOfBirthDatePicker -> TODO()
            is RegisterScreen2Action.NextOnClick -> nextOnClick(action)
        }
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


    }



}