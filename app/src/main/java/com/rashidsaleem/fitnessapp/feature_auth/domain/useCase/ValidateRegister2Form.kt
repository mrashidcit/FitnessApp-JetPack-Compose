package com.rashidsaleem.fitnessapp.feature_auth.domain.useCase

data class ValidateRegister2Form(
    val validateGender: ValidateGender,
    val validateDateOfBirth: ValidateDateOfBirth,
    val validateWeight: ValidateWeight,
    val validateHeight: ValidateHeight,
)
