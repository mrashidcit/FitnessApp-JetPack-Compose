package com.rashidsaleem.fitnessapp.feature_auth.di

import com.rashidsaleem.fitnessapp.feature_auth.domain.useCase.ValidateEmail
import com.rashidsaleem.fitnessapp.feature_auth.domain.useCase.ValidateFullName
import com.rashidsaleem.fitnessapp.feature_auth.domain.useCase.ValidatePassword
import com.rashidsaleem.fitnessapp.feature_auth.domain.useCase.ValidatePhoneNumber
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

    @Provides
    @Singleton
    fun provideValidateRegisterForm(): ValidateRegisterForm {
        return ValidateRegisterForm(
            validateFullName = ValidateFullName(),
            validatePhoneNumber = ValidatePhoneNumber(),
            validateEmail = ValidateEmail(),
            validatePassword = ValidatePassword()
        )
    }
}