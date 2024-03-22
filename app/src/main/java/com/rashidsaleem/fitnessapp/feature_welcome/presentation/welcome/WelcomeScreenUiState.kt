package com.rashidsaleem.fitnessapp.feature_welcome.presentation.welcome

data class WelcomeScreenUiState(
    val screen: WelcomeScreenEnum = WelcomeScreenEnum.Screen1,
)

enum class WelcomeScreenEnum {
    Screen1,
    Screen2,
}


val previewWelcomeScreenUiState = WelcomeScreenUiState(

)