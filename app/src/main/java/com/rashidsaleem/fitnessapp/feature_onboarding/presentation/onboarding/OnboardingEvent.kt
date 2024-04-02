package com.rashidsaleem.fitnessapp.feature_onboarding.presentation.onboarding

sealed class OnboardingEvent {
    object MoveNext: OnboardingEvent()
}