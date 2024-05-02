package com.rashidsaleem.fitnessapp.feature_auth.domain.useCase

data class ValidateRegisterForm(
    val validateFullName: ValidateFullName,
    val validatePhoneNumber: ValidatePhoneNumber,
    val validateEmail: ValidateEmail,
    val validatePassword: ValidatePassword,
    val validatePolicyAndTerms: ValidatePolicyAndTerms,
)
