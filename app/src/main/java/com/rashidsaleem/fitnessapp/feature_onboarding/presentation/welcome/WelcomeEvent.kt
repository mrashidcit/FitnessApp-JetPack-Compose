package com.rashidsaleem.fitnessapp.feature_onboarding.presentation.welcome

sealed class WelcomeEvent {
    object GetStarted: WelcomeEvent()
}