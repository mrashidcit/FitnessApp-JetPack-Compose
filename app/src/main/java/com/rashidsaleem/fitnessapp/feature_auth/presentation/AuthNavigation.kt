package com.rashidsaleem.fitnessapp.feature_auth.presentation

import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.rashidsaleem.fitnessapp.core.common.Routes
import com.rashidsaleem.fitnessapp.core.presentation.sharedViewModel
import com.rashidsaleem.fitnessapp.feature_auth.presentation.registerScreen1.RegisterScreen1
import com.rashidsaleem.fitnessapp.feature_auth.presentation.registerScreen2.RegisterScreen2
import com.rashidsaleem.fitnessapp.feature_auth.presentation.viewmodels.AuthViewModel

fun NavGraphBuilder.authNavigation(navController: NavHostController) {



    composable(Routes.REGISTER_SCREEN_1) {
        val authViewModel = it.sharedViewModel<AuthViewModel>(navController = navController)
//        val authViewModel = viewModel(LocalContext.current as ComponentActivity)

        RegisterScreen1(
            authViewModel = authViewModel,
            navigateNext = { route, params ->
                navController.navigate(route)
            }
        )
    }

    composable(Routes.REGISTER_SCREEN_2) {

        RegisterScreen2()
    }
}