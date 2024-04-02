package com.rashidsaleem.fitnessapp.feature_onboarding.presentation.welcome

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewModelScope
import com.rashidsaleem.fitnessapp.R
import com.rashidsaleem.fitnessapp.core.presentation.ui.theme.PurpleLinear
import com.rashidsaleem.fitnessapp.core.presentation.baseScreen.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(

) : BaseViewModel() {

    private val _scope = viewModelScope
    private val _uiState = MutableStateFlow(WelcomeScreenUiState())
    val uiState = _uiState.asStateFlow()

    private fun updateUiState(
        screenEnum: WelcomeScreenEnum? = null,
        @DrawableRes logoImage: Int? = null,
        backgroundColor: List<Color>? = null,
    ) {
        _uiState.update {
            it.copy(
                screenEnum = screenEnum ?: it.screenEnum,
                logoImage = logoImage ?: it.logoImage,
                backgroundColor = backgroundColor ?: it.backgroundColor,
            )
        }
    }

    fun onEvent(event: WelcomeEvent) {
        when (event) {
            WelcomeEvent.GetStarted -> getStarted()
        }
    }

    private fun getStarted() {
        _scope.launch {
            val currentScreenEnum = _uiState.value.screenEnum
            var logoImage: Int
            var backgroundColor: List<Color>

            val nextScreenEnum = when (currentScreenEnum) {
                WelcomeScreenEnum.Screen1 -> {
                    logoImage = R.drawable.ic_didpoolfit_blue_and_black
                    backgroundColor = PurpleLinear

                    WelcomeScreenEnum.Screen2
                }
                WelcomeScreenEnum.Screen2 -> {
                    launch(Dispatchers.Main) {
                        _eventFlow.emit()
                    }
                }
            }

        }
    }


}