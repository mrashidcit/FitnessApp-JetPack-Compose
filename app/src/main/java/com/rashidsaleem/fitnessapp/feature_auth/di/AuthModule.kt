package com.rashidsaleem.fitnessapp.feature_auth.di

import com.rashidsaleem.fitnessapp.feature_auth.domain.useCase.ValidateEmail
import com.rashidsaleem.fitnessapp.feature_auth.domain.useCase.ValidateFullName
import com.rashidsaleem.fitnessapp.feature_auth.domain.useCase.ValidatePassword
import com.rashidsaleem.fitnessapp.feature_auth.domain.useCase.ValidatePhoneNumber
import com.rashidsaleem.fitnessapp.feature_auth.domain.useCase.ValidatePolicyAndTerms
import com.rashidsaleem.fitnessapp.feature_auth.domain.useCase.ValidateRegister2Form
import com.rashidsaleem.fitnessapp.feature_auth.domain.useCase.ValidateRegisterForm
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AuthModule {

    @Singleton
    @Provides
    fun provideValidateFullName(): ValidateFullName {
        return ValidateFullName()
    }

    @Singleton
    @Provides
    fun provideValidateRegisterForm(): ValidateRegisterForm {
        return ValidateRegisterForm(
            validateFullName = ValidateFullName(),
            validatePhoneNumber = ValidatePhoneNumber(),
            validateEmail = ValidateEmail(),
            validatePassword = ValidatePassword(),
            validatePolicyAndTerms = ValidatePolicyAndTerms(),
        )
    }


}