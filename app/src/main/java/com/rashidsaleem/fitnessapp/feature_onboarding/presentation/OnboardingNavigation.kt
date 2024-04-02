package com.rashidsaleem.fitnessapp.feature_onboarding.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.rashidsaleem.fitnessapp.core.common.Routes
import com.rashidsaleem.fitnessapp.feature_onboarding.presentation.onboarding.OnboardingScreen
import com.rashidsaleem.fitnessapp.feature_onboarding.presentation.welcome.WelcomeScreen

fun NavGraphBuilder.onboardingNavigation(navController: NavHostController) {
    composable(Routes.WELCOME) {
        WelcomeScreen(
            navigateNext = { route ->
                navController.navigate(route)
            }
        )
    }

    composable(Routes.ONBOARDING) {
        OnboardingScreen(
            navigateNext = { route ->
                navController.navigate(route)
            }
        )
    }
}