package com.rashidsaleem.fitnessapp.feature_auth.presentation.registerScreen1

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rashidsaleem.fitnessapp.core.common.Routes
import com.rashidsaleem.fitnessapp.feature_auth.presentation.registerScreen1.components.RegisterScreen1Content
import com.rashidsaleem.fitnessapp.feature_auth.presentation.viewmodels.AuthViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun RegisterScreen1(
    authViewModel: AuthViewModel,
    viewModel: RegisterScreen1ViewModel = hiltViewModel(),
    navigateNext: (String, Bundle?) -> Unit,
) {

    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is RegisterScreen1ViewModel.UiEvent.Register -> {
                    authViewModel.updateUser(event.user)

                    navigateNext(Routes.REGISTER_SCREEN_2, null)
                }
            }
        }
    }

    RegisterScreen1Content(
        uiState = uiState,
        onEvent = viewModel::onEvent
    )
}