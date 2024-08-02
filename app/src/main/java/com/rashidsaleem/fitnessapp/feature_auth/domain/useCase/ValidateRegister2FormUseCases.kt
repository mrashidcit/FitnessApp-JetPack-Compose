package com.rashidsaleem.fitnessapp.feature_auth.domain.useCase

data class ValidateRegister2FormUseCases(
    val validateGenderUseCase: ValidateGenderUseCase,
    val validateDateOfBirth: ValidateDateOfBirth,
    val validateWeight: ValidateWeight,
    val validateHeight: ValidateHeight,
)
