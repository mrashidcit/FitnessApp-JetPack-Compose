package com.rashidsaleem.fitnessapp.feature_auth.presentation.registerScreen1.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.FitnessAppTheme
import com.rashidsaleem.fitnessapp.feature_auth.presentation.registerScreen1.RegisterEvent
import com.rashidsaleem.fitnessapp.feature_auth.presentation.registerScreen1.RegisterUiState
import com.rashidsaleem.fitnessapp.feature_auth.presentation.registerScreen1.previewRegisterUiState

@Composable
fun RegisterScreen1Content(
    uiState: RegisterUiState,
    onEvent: (RegisterEvent) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White
            )
            .verticalScroll(rememberScrollState())
            .padding(
                horizontal = 30.dp
            )
    ) {
        TopContainer(
            uiState = uiState,
            onEvent = onEvent,
        )
        Spacer(modifier = Modifier.height(50.dp))
        BottomContainer(
            onEvent = onEvent
        )
    }
}

@Preview
@Composable
fun RegisterScreen1ContentPreview() {
    FitnessAppTheme {
        Surface {
            val uiState = remember {
                previewRegisterUiState
            }
            RegisterScreen1Content(
                uiState = uiState,
                onEvent = {}
            )
        }
    }
}

