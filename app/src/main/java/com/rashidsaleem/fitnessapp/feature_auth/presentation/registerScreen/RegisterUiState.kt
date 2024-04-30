package com.rashidsaleem.fitnessapp.feature_auth.presentation.registerScreen

data class RegisterUiState(
    val fullName: String = "",
    val phoneNumber: String = "",
    val email: String = "",
    val password: String = "",
    val policyAndTermsAccepted: Boolean = false,
    val passwordVisibility: Boolean = false,
)

val previewRegisterUiState = RegisterUiState(
    fullName = "Rashid Saleem",
    phoneNumber = "+923023888798",
    email = "mrashidcit@gmail.com",
    password = "abc1234",
    policyAndTermsAccepted = false,
)
