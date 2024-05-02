package com.rashidsaleem.fitnessapp.core.presentation.baseScreen

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

open class BaseViewModel: ViewModel() {

    private val _scope = viewModelScope
    private val _baseEventFlow = MutableSharedFlow<UiEvent>()
    val baseEventFlow = _baseEventFlow.asSharedFlow()


    fun navigateNext(route: String, params: Bundle? = null) {
        _scope.launch(Dispatchers.Main) {
            _baseEventFlow.emit(UiEvent.NavigateNext(route, params))
        }
    }

    fun navigateBack(route: String = "", params: Bundle? = null) {
        _scope.launch(Dispatchers.Main) {
            _baseEventFlow.emit(UiEvent.NavigateBack(route, params))
        }
    }

    sealed class UiEvent {
        data class NavigateNext(val route: String, val params: Bundle? = null): UiEvent()

        /**
         * @param route - If route is empty that means navigate to previousScreen only
         *     and not empty that means navigate back to that particular route
         */
        data class NavigateBack(val route: String, val params: Bundle? = null): UiEvent()
    }
}