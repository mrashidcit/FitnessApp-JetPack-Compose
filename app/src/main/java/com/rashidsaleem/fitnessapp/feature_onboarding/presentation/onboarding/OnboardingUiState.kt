package com.rashidsaleem.fitnessapp.feature_onboarding.presentation.onboarding

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.rashidsaleem.fitnessapp.R

/**
 *
 * @param progressValue - Range between 0f to 1.0f and should be increment by 0.25f
 * on each step
 */
data class OnboardingUiState(
    val onboardingEnum: OnboardingEnum = OnboardingEnum.Onboarding1,
    val progressValue: Float = 0.25f,
    @DrawableRes val image: Int = R.drawable.img_onboarding_1,
    @StringRes val title: Int = R.string.track_you_goal,
    @StringRes val description: Int = R.string.dont_worry_if_you_have_trouble_determining_your_goals,
)

enum class OnboardingEnum {
    Onboarding1,
    Onboarding2,
    Onboarding3,
    Onboarding4,
}

val previewOnboardingUiState = OnboardingUiState(

)


