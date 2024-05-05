package com.rashidsaleem.fitnessapp.feature_auth.presentation.registerScreen1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rashidsaleem.fitnessapp.core.presentation.baseScreen.BaseViewModel
import com.rashidsaleem.fitnessapp.feature_auth.domain.models.UserModel
import com.rashidsaleem.fitnessapp.feature_auth.domain.useCase.ValidateEmail
import com.rashidsaleem.fitnessapp.feature_auth.domain.useCase.ValidateFullName
import com.rashidsaleem.fitnessapp.feature_auth.domain.useCase.ValidatePassword
import com.rashidsaleem.fitnessapp.feature_auth.domain.useCase.ValidatePhoneNumber
import com.rashidsaleem.fitnessapp.feature_auth.domain.useCase.ValidatePolicyAndTerms
import com.rashidsaleem.fitnessapp.feature_auth.domain.useCase.ValidateRegisterForm
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterScreen1ViewModel @Inject constructor(
   private val validateForm: ValidateRegisterForm
) : ViewModel() {

//    private val validateForm: ValidateRegisterForm = ValidateRegisterForm(
//        validateFullName = ValidateFullName(),
//        validatePhoneNumber = ValidatePhoneNumber(),
//        validateEmail = ValidateEmail(),
//        validatePassword = ValidatePassword(),
//        validatePolicyAndTerms = ValidatePolicyAndTerms(),
//    )
    private val _scope = viewModelScope
    private val _uiState = MutableStateFlow(RegisterUiState())
    val uiState = _uiState.asStateFlow()

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

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
                policyAndTerms = policyAndTermsCheck ?: it.policyAndTerms,
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

    private fun loginWithFacebook() = _scope.launch {
        TODO("Not yet implemented")
    }

    private fun loginWithGoogle() {
        TODO("Not yet implemented")
    }

    private fun registerOnClick() = _scope.launch(Dispatchers.Default) {
      val fullNameResult = validateForm.validateFullName.execute(_uiState.value.fullName)
      val phoneNumberResult = validateForm.validatePhoneNumber.execute(_uiState.value.phoneNumber)
      val emailResult = validateForm.validateEmail.execute(_uiState.value.email)
      val passwordResult = validateForm.validatePassword.execute(_uiState.value.password)
      val policyAndTermsResult = validateForm.validatePolicyAndTerms.execute(_uiState.value.policyAndTerms)

      val hasError = listOf(
         fullNameResult,
         phoneNumberResult,
         emailResult,
         passwordResult,
         policyAndTermsResult
      ).any { !it.successful }

      if (hasError) {
         _uiState.update {
            it.copy(
               fullNameError = fullNameResult.errorMessage,
               phoneNumberError = phoneNumberResult.errorMessage,
               emailError = emailResult.errorMessage,
               passwordError = passwordResult.errorMessage,
               policyAndTermsError = policyAndTermsResult.errorMessage
            )
         }
         return@launch
      }

      val userModel = _uiState.value.let {
         UserModel(
            fullName = it.fullName,
            phoneNumber = it.phoneNumber,
            email = it.email,
            password = it.password
         )
      }
      launch(Dispatchers.Main) {
         _eventFlow.emit(UiEvent.Register(userModel))
      }
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

    sealed class UiEvent {
        data class Register(val user: UserModel) : UiEvent()
    }

}