package com.rashidsaleem.fitnessapp.feature_auth.domain.useCase

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import com.google.common.truth.Truth.assertThat

@RunWith(AndroidJUnit4::class)
class ValidateEmailTest {

    lateinit var validateEmail: ValidateEmail

    @Before
    fun setUp() {
        validateEmail = ValidateEmail()
    }

    @After
    fun destroy() {

    }


    // Given , When , Then

    @Test
    fun validEmail_expectingTrueInResponse() {
        // Given : using valid email
        val email = "mrashidcit@gmail.com"

        // When : validating email
        val result = validateEmail.execute(email)

        // Then : validating result
        assertThat(result.successful).isEqualTo(true)
    }

    @Test
    fun validEmail2_expectingTrueInResponse() {
        // Given : using valid email
        val email = "abc@test.com"

        // When : validating email
        val result = validateEmail.execute(email)

        // Then : validating result
        assertThat(result.successful).isEqualTo(true)
    }

    @Test
    fun invalidEmail_expectingFalseInResponse() {
        // Given : using valid email
        val email = "ab c@test.com"

        // When : validating email
        val result = validateEmail.execute(email)

        // Then : validating result
        assertThat(result.successful).isEqualTo(false)
    }



}