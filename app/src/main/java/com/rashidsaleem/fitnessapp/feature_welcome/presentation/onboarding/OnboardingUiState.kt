package com.rashidsaleem.fitnessapp.feature_welcome.presentation.onboarding

/**
 *
 * @param progressValue - Range between 0f to 1.0f and should be increment by 0.25f
 * on each step
 */
data class OnboardingUiState(
    val progressValue: Float = 0f,
)

val previewOnboardingUiState = OnboardingUiState(

)
