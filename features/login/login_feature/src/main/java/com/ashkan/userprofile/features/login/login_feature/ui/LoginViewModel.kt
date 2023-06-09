package com.ashkan.userprofile.features.login.login_feature.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ashkan.userprofile.features.login.domain.usecase.LoginUseCase
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel : ViewModel() {

    @Inject
    lateinit var loginUseCase: LoginUseCase

    fun startLogin() = viewModelScope.launch {
        loginUseCase.invoke(
            LoginUseCase.Params(
                userName = "ashkan",
                password = "ashkan12345"
            )
        ).onStart {

        }.collect {

        }
    }
}