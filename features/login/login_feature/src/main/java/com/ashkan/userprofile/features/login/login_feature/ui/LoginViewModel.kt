package com.ashkan.userprofile.features.login.login_feature.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ashkan.userprofile.common.ui.UiState
import com.ashkan.userprofile.common.ui.toUiState
import com.ashkan.userprofile.features.login.domain.data.LoginResponse
import com.ashkan.userprofile.features.login.domain.usecase.LoginUseCase
import com.ashkan.userprofile.features.login.login_feature.di.LoginComponent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel @Inject constructor(): ViewModel() {

    @Inject
    lateinit var loginUseCase: LoginUseCase

    private var _profileFlow = MutableStateFlow<UiState<List<LoginResponse>>>(UiState.None())
    val profileFlow = _profileFlow.asStateFlow()
    val userList = mutableListOf<LoginResponse>()

    init {
        LoginComponent.instance?.inject(this@LoginViewModel)
    }

    fun startLogin() = viewModelScope.launch {
        loginUseCase.invoke(
            LoginUseCase.Params(
                userName = "ashkan",
                password = "ashkan12345"
            )
        ).onStart {
            _profileFlow.emit(UiState.Loading())
        }.collect {
            it.onSuccess { users ->
                userList.addAll(users)
            }
            _profileFlow.emit(it.toUiState())
        }
    }
}