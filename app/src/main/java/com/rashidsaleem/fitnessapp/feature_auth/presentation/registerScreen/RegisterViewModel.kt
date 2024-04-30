package com.rashidsaleem.fitnessapp.feature_auth.presentation.registerScreen

import androidx.lifecycle.viewModelScope
import com.rashidsaleem.fitnessapp.core.presentation.baseScreen.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@HiltViewModel
class RegisterViewModel: BaseViewModel() {

   private val _scope = viewModelScope
   private val _uiState = MutableStateFlow(RegisterUiState())
   val uiState = _uiState.asStateFlow()

   fun updateUiState(
      fullName: String? = null,
      phoneNumber: String? = null,
      email: String? = null,
      password: String? = null,
      passwordVisibility: Boolean? = null,
      policyAndTermsCheck: Boolean? = null,
   ) {
      _uiState.update {
         it.copy(
            fullName = fullName ?: it.fullName,
            phoneNumber = phoneNumber ?: it.phoneNumber,
            email = email ?: it.email,
            password = password ?: it.password,
            passwordVisibility = passwordVisibility ?: it.passwordVisibility,
            policyAndTermsAccepted = policyAndTermsCheck ?: it.policyAndTermsAccepted,
         )
      }
   }

   fun onEvent(event: RegisterEvent) {
      when (event) {
         RegisterEvent.LoginOnClick -> loginOnClick()
         RegisterEvent.LoginWithFacebookOnClick -> loginWithFacebook()
         RegisterEvent.LoginWithGoogleOnClick -> loginWithGoogle()
         RegisterEvent.RegisterOnClick -> registerOnClick()
         is RegisterEvent.UpdateEmail -> updateEmail(event.value)
         is RegisterEvent.UpdateFullName -> updateFullName(event.value)
         is RegisterEvent.UpdatePassword -> updatePassword(event.value)
         is RegisterEvent.UpdatePasswordVisibility -> updatePasswordVisibility(event.value)
         is RegisterEvent.UpdatePhoneNumber -> updatePhoneNumber(event.value)
         is RegisterEvent.UpdatePolicyAndTermsCheck -> updatePolicyAndTermsCheck(event.value)
      }
   }

   private fun updatePolicyAndTermsCheck(value: Boolean) {
      updateUiState(
         policyAndTermsCheck = value
      )
   }

   private fun updatePhoneNumber(value: String) {
      updateUiState(
         phoneNumber = value
      )
   }

   private fun updatePasswordVisibility(value: Boolean) {
      updateUiState(
         passwordVisibility = value
      )
   }

   private fun updatePassword(value: String) {
      updateUiState(
         password = value
      )
   }

   private fun loginOnClick() {
      TODO("Not yet implemented")
   }

   private fun loginWithFacebook() {
      TODO("Not yet implemented")
   }

   private fun loginWithGoogle() {
      TODO("Not yet implemented")
   }

   private fun registerOnClick() {
      TODO("Not yet implemented")
   }

   private fun updateEmail(value: String) {
      updateUiState(
         email = value
      )
   }

   private fun updateFullName(value: String) {
      updateUiState(
         fullName = value
      )
   }

}