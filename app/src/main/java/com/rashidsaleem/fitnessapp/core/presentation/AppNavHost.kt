package com.rashidsaleem.fitnessapp.core.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.rashidsaleem.fitnessapp.core.common.Routes
import com.rashidsaleem.fitnessapp.feature_auth.presentation.authNavigation
import com.rashidsaleem.fitnessapp.feature_onboarding.presentation.onboardingNavigation

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Routes.WELCOME
    ) {

        onboardingNavigation(
            navController = navController
        )

        authNavigation(
            navController = navController
        )
    }
}