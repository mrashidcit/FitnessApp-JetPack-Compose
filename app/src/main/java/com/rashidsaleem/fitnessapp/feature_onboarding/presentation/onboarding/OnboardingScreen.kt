package com.rashidsaleem.fitnessapp.feature_onboarding.presentation.onboarding

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rashidsaleem.fitnessapp.feature_onboarding.presentation.onboarding.components.OnboardingContent

@Composable
fun OnboardingScreen(
    viewModel: OnboardingViewModel = viewModel()
) {

    val uiState by viewModel.uiState.collectAsState()

    OnboardingContent(
        uiState = uiState,
        onEvent = viewModel::onEvent
    )

}