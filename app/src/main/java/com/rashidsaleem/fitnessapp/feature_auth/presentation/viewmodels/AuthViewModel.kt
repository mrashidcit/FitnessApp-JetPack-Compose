package com.rashidsaleem.fitnessapp.feature_auth.presentation.viewmodels

import com.rashidsaleem.fitnessapp.core.presentation.baseScreen.BaseViewModel
import com.rashidsaleem.fitnessapp.feature_auth.presentation.registerScreen.RegisterUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

@HiltViewModel
class AuthViewModel: BaseViewModel() {

    private val _registerScreen1UiState = MutableStateFlow(RegisterUiState())
    val registerScreen1UiState = _registerScreen1UiState.asStateFlow()


}