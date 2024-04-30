package com.rashidsaleem.fitnessapp.feature_auth.presentation.registerScreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rashidsaleem.fitnessapp.feature_auth.presentation.registerScreen.components.RegisterScreenContent

@Composable
fun RegisterScreen(
    viewModel: RegisterViewModel = viewModel()
) {

    val uiState by viewModel.uiState.collectAsState()

    RegisterScreenContent(
        uiState = uiState,
        onEvent = viewModel::onEvent
        )
}