package com.rashidsaleem.fitnessapp.feature_auth.presentation.registerScreen2

import android.os.Bundle
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.rashidsaleem.fitnessapp.core.presentation.baseScreen.BaseViewModel
import com.rashidsaleem.fitnessapp.feature_auth.presentation.registerScreen2.components.RegisterScreen2Content
import kotlinx.coroutines.flow.collectLatest

@Composable
fun RegisterScreen2(
    viewModel: RegisterScreen2ViewModel = hiltViewModel(),
    navigateNext: (String, Bundle?) -> Unit,
    navigateBack: () -> Unit
) {

    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(key1 = true) {
        viewModel.baseEventFlow.collectLatest { event ->
            when (event) {
                is BaseViewModel.UiEvent.NavigateBack -> navigateBack()
                is BaseViewModel.UiEvent.NavigateNext -> navigateNext(event.route, event.params)
            }
        }
    }

    RegisterScreen2Content(
        uiState = uiState,
        action = viewModel::onAction
    )
}