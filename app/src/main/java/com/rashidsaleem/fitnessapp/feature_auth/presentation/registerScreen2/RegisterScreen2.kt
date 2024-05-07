package com.rashidsaleem.fitnessapp.feature_auth.presentation.registerScreen2

import android.os.Bundle
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.rashidsaleem.fitnessapp.feature_auth.presentation.registerScreen2.components.RegisterScreen2Content

@Composable
fun RegisterScreen2(
    viewModel: RegisterScreen2ViewModel = hiltViewModel(),
    navigateNext: (String, Bundle) -> Unit,
    navigateBack: () -> Unit
) {

    RegisterScreen2Content()
}