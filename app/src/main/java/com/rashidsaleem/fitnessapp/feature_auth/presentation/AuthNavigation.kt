package com.rashidsaleem.fitnessapp.feature_auth.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.rashidsaleem.fitnessapp.core.common.Routes
import com.rashidsaleem.fitnessapp.feature_auth.presentation.registerScreen.RegisterScreen

fun NavGraphBuilder.authNavigation(navController: NavHostController) {

    composable(Routes.REGISTER_SCREEN_1) {
        RegisterScreen()
    }
}