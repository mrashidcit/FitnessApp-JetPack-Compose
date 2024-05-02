package com.rashidsaleem.fitnessapp.feature_auth.presentation.viewmodels

import com.rashidsaleem.fitnessapp.core.presentation.baseScreen.BaseViewModel
import com.rashidsaleem.fitnessapp.feature_auth.domain.models.UserModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(

) : BaseViewModel() {

    private var _userModel = UserModel()

    fun updateUser(user: UserModel) {
        _userModel = user
    }


}