package com.rashidsaleem.fitnessapp.feature_onboarding.presentation.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rashidsaleem.fitnessapp.R
import com.rashidsaleem.fitnessapp.core.common.Routes
import com.rashidsaleem.fitnessapp.core.presentation.baseScreen.BaseViewModel
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
class OnboardingViewModel @Inject constructor(

) : BaseViewModel() {

    private val _scope = viewModelScope
    private val _uiState = MutableStateFlow(OnboardingUiState())
    val uiState = _uiState.asStateFlow()
    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private fun updateUiState(
        onboardingEnum: OnboardingEnum? = null,
        progressValue: Float? = null,
        image: Int? = null,
        title: Int? = null,
        description: Int? = null,
    ) {
        _uiState.update {
            it.copy(
                onboardingEnum = onboardingEnum ?: it.onboardingEnum,
                progressValue = progressValue ?: it.progressValue,
                image = image ?: it.image,
                title = title ?: it.title,
                description = description ?: it.description,
            )
        }
    }

    fun onEvent(event: OnboardingEvent) {
        when (event) {
            OnboardingEvent.MoveNext -> moveNext()
        }
    }

    private fun moveNext() {
        _scope.launch {
            val currentOnboardingEnum = _uiState.value.onboardingEnum
            var progressValue: Float = 0.25f
            var image: Int = R.drawable.img_onboarding_1
            var title: Int = R.string.track_you_goal
            var description: Int = R.string.dont_worry_if_you_have_trouble_determining_your_goals

            val nextOnboardingEnum = when (currentOnboardingEnum) {
                OnboardingEnum.Onboarding1 -> {
                    progressValue = 0.50f
                    image = R.drawable.img_onboarding_2
                    title = R.string.get_burn
                    description = R.string.lets_keep_burning_to_achieve_yours_goals

                    OnboardingEnum.Onboarding2
                }
                OnboardingEnum.Onboarding2 -> {
                    progressValue = 0.75f
                    image = R.drawable.img_onboarding_3
                    title = R.string.eat_well
                    description = R.string.lets_start_a_healthy_lifestyle_with_us

                    OnboardingEnum.Onboarding3
                }
                OnboardingEnum.Onboarding3 -> {
                    progressValue = 1f
                    image = R.drawable.img_onboarding_4
                    title = R.string.improve_sleep_quality
                    description = R.string.improve_the_quality_of_your_sleep_with_us

                    OnboardingEnum.Onboarding4
                }
                OnboardingEnum.Onboarding4 -> {
                    navigateNext(Routes.REGISTER_SCREEN_1)
                    return@launch
                }
            }

            updateUiState(
                onboardingEnum = nextOnboardingEnum,
                progressValue = progressValue,
                image = image,
                title = title,
                description = description,
            )


        }

    }

    sealed class UiEvent {
//        data class NavigateNext(val route: String): UiEvent()
    }

}