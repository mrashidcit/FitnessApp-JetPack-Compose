package com.rashidsaleem.fitnessapp.feature_auth.domain.models

import com.rashidsaleem.fitnessapp.core.common.enums.GenderEnum
import java.util.Date

data class UserModel(
    val fullName: String = "",
    val phoneNumber: String = "",
    val email: String = "",
    val password: String = "",
    val gender: GenderEnum? = null,
    val dob: Date? = null,
    val weight: Float = 0.0f,
    val height: Float = 0.0f,
)
