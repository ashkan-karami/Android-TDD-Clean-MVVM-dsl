package com.ashkan.userprofile.features.login.login_feature.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ashkan.userprofile.common.base_domain.baseUseCase.UseCase
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

    private var _userListFlow = MutableStateFlow<UiState<List<LoginResponse>>>(UiState.None())
    val userListFlow = _userListFlow.asStateFlow()

    init {
        LoginComponent.instance?.inject(this@LoginViewModel)
    }

    fun startLogin() = viewModelScope.launch {
        loginUseCase.invoke(
            UseCase.NoParam
        ).onStart {
            _userListFlow.emit(UiState.Loading())
        }.collect {
            _userListFlow.emit(it.toUiState())
        }
    }
}