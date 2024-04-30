package com.rashidsaleem.fitnessapp.feature_auth.domain.useCase

data class ValidationResult(
    val successful: Boolean,
    val errorMessage: String? = null,
)
