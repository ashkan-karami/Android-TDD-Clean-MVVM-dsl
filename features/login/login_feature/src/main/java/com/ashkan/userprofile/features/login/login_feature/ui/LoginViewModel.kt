package com.ashkan.userprofile.features.login.login_feature.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ashkan.userprofile.common.ui.UiState
import com.ashkan.userprofile.common.ui.toUiState
import com.ashkan.userprofile.features.login.domain.data.LoginResponse
import com.ashkan.userprofile.features.login.domain.usecase.LoginUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel : ViewModel() {

    @Inject
    lateinit var loginUseCase: LoginUseCase

    private var _profileFlow = MutableStateFlow<UiState<LoginResponse>>(UiState.None())
    val profileFlow = _profileFlow.asStateFlow()

    fun startLogin() = viewModelScope.launch {
        loginUseCase.invoke(
            LoginUseCase.Params(
                userName = "ashkan",
                password = "ashkan12345"
            )
        ).onStart {
            _profileFlow.emit(UiState.Loading())
        }.collect {
            _profileFlow.emit(it.toUiState())
        }
    }
}