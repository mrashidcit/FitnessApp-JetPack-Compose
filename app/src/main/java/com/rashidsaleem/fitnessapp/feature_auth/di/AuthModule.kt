package com.rashidsaleem.fitnessapp.feature_auth.di

import com.rashidsaleem.fitnessapp.core.common.util.ResourceProvider
import com.rashidsaleem.fitnessapp.feature_auth.domain.useCase.ValidateDateOfBirth
import com.rashidsaleem.fitnessapp.feature_auth.domain.useCase.ValidateEmail
import com.rashidsaleem.fitnessapp.feature_auth.domain.useCase.ValidateFullName
import com.rashidsaleem.fitnessapp.feature_auth.domain.useCase.ValidateGenderUseCase
import com.rashidsaleem.fitnessapp.feature_auth.domain.useCase.ValidateHeight
import com.rashidsaleem.fitnessapp.feature_auth.domain.useCase.ValidatePassword
import com.rashidsaleem.fitnessapp.feature_auth.domain.useCase.ValidatePhoneNumber
import com.rashidsaleem.fitnessapp.feature_auth.domain.useCase.ValidatePolicyAndTerms
import com.rashidsaleem.fitnessapp.feature_auth.domain.useCase.ValidateRegister2FormUseCases
import com.rashidsaleem.fitnessapp.feature_auth.domain.useCase.ValidateRegisterForm
import com.rashidsaleem.fitnessapp.feature_auth.domain.useCase.ValidateWeight
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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

    /**
     * ***** UseCase ******
     */

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

    @Singleton
    @Provides
    fun provideValidateRegister2FormUseCases(resourceProvider: ResourceProvider): ValidateRegister2FormUseCases {
        return ValidateRegister2FormUseCases(
            validateGenderUseCase = ValidateGenderUseCase(resourceProvider),
            validateDateOfBirth = ValidateDateOfBirth(),
            validateWeight = ValidateWeight(),
            validateHeight = ValidateHeight(),
        )
    }


}