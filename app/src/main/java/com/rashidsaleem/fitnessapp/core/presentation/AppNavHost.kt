package com.rashidsaleem.fitnessapp.core.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.rashidsaleem.fitnessapp.core.common.Routes
import com.rashidsaleem.fitnessapp.feature_auth.presentation.authNavigation
import com.rashidsaleem.fitnessapp.feature_onboarding.presentation.onboardingNavigation

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
//        startDestination = Routes.WELCOME
//        startDestination = Routes.REGISTER_SCREEN_1
        startDestination = Routes.REGISTER_SCREEN_2
    ) {

        onboardingNavigation(
            navController = navController
        )

        authNavigation(
            navController = navController
        )
    }
}

@Composable
inline fun <reified T: ViewModel> NavBackStackEntry.sharedViewModel(navController: NavController): T {
    val navGraphRoute = destination.parent?.route ?: return viewModel()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }

    return viewModel(parentEntry)
}