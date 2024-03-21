package com.rashidsaleem.fitnessapp.feature_welcome.presentation

data class WelcomeScreenUiState(
        val screen: WelcomeScreenEnum = WelcomeScreenEnum.Screen1,
)

enum class WelcomeScreenEnum {
    Screen1,
    Screen2,
}


val previewWelcomeScreenUiState = WelcomeScreenUiState(

)