package com.rashidsaleem.fitnessapp.feature_onboarding.presentation.welcome

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.rashidsaleem.fitnessapp.R
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.WhiteLinear

data class WelcomeScreenUiState(
    val screenEnum: WelcomeScreenEnum = WelcomeScreenEnum.Screen1,
    @DrawableRes val logoImage: Int = R.drawable.ic_didpoolfit_blue_and_black,
    val backgroundColor: List<Color> = WhiteLinear,
    )

enum class WelcomeScreenEnum {
    Screen1,
    Screen2,
}


val previewWelcomeScreenUiState = WelcomeScreenUiState(

)