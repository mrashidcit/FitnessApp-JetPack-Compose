package com.rashidsaleem.fitnessapp.feature_auth.presentation.registerScreen

sealed class RegisterEvent {
    data class UpdateFullName(val value: String): RegisterEvent()
    data class UpdatePhoneNumber(val value: String): RegisterEvent()
    data class UpdateEmail(val value: String): RegisterEvent()
    data class UpdatePassword(val value: String): RegisterEvent()
    data class UpdatePasswordVisibility(val value: Boolean): RegisterEvent()
    data class UpdatePolicyAndTermsCheck(val value: Boolean): RegisterEvent()
    object RegisterOnClick: RegisterEvent()
    object LoginWithGoogleOnClick: RegisterEvent()
    object LoginWithFacebookOnClick: RegisterEvent()
    object LoginOnClick: RegisterEvent()

}