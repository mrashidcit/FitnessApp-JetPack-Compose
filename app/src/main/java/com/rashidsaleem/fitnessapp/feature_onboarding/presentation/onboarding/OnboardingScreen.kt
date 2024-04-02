package com.rashidsaleem.fitnessapp.feature_onboarding.presentation.onboarding

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rashidsaleem.fitnessapp.core.presentation.baseScreen.BaseViewModel
import com.rashidsaleem.fitnessapp.feature_onboarding.presentation.onboarding.components.OnboardingContent
import kotlinx.coroutines.flow.collectLatest

@Composable
fun OnboardingScreen(
    viewModel: OnboardingViewModel = viewModel(),
    navigateNext: (String) -> Unit

) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(key1 = true) {
        viewModel.baseEventFlow.collectLatest { event ->
            when (event) {
                is BaseViewModel.UiEvent.NavigateNext -> navigateNext(event.route)
                is BaseViewModel.UiEvent.NavigateBack -> { }
            }
        }
    }

    OnboardingContent(
        uiState = uiState,
        onEvent = viewModel::onEvent
    )

}