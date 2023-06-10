package com.ashkan.userprofile.features.login.login_feature.di

import com.ashkan.userprofile.features.login.login_feature.ui.LoginViewModel

interface ViewModelInjector {

    fun inject(viewModel: LoginViewModel)
}