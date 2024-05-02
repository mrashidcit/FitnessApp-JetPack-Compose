package com.rashidsaleem.fitnessapp.feature_auth.presentation.registerScreen1

data class RegisterUiState(
    val fullName: String = "",
    val fullNameError: String? = null,
    val phoneNumber: String = "",
    val phoneNumberError: String? = null,
    val email: String = "",
    val emailError: String? = null,
    val password: String = "",
    val passwordError: String? = null,
    val policyAndTerms: Boolean = false,
    val policyAndTermsError: String? = null,
    val passwordVisibility: Boolean = false,
)

val previewRegisterUiState = RegisterUiState(
    fullName = "Rashid Saleem",
    phoneNumber = "+923023888798",
    email = "mrashidcit@gmail.com",
    password = "abc1234",
    policyAndTerms = false,
)
