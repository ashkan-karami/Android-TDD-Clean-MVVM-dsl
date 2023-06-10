package com.ashkan.userprofile.features.login.login_feature.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.ashkan.userprofile.common.navigation.NavigationFlow
import com.ashkan.userprofile.common.navigation.crossNavigate
import com.ashkan.userprofile.common.ui.BaseFragment
import com.ashkan.userprofile.common.ui.foldResponse
import com.ashkan.userprofile.di.DaggerDependencies
import com.ashkan.userprofile.features.login.login_feature.R
import com.ashkan.userprofile.features.login.login_feature.databinding.FragmentLoginBinding
import com.ashkan.userprofile.features.login.login_feature.di.DaggerLoginComponent
import com.ashkan.userprofile.features.login.login_feature.di.LoginComponent
import dagger.hilt.android.EntryPointAccessors
import kotlinx.coroutines.launch


class LoginFragment : BaseFragment<FragmentLoginBinding>(
    layout = R.layout.fragment_login
) {

    private val viewModel by viewModels<LoginViewModel>()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        inject()
    }

    override fun bind(savedInstanceState: Bundle?) {
        collectViewModel()
        dataBinding.lifecycleOwner = viewLifecycleOwner
        dataBinding.submit = {
            viewModel.startLogin()
            crossNavigate(NavigationFlow.ProfileFlow)
        }
    }

    private fun inject() {
        DaggerLoginComponent
            .builder()
            .context(requireContext())
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    requireContext(),
                    DaggerDependencies::class.java
                )
            )
            .build().also {
                LoginComponent.instance = it
            }.apply {
                inject(this@LoginFragment)
            }
    }

    private fun collectViewModel(){
        lifecycleScope.launch {
            viewModel.profileFlow.collect{
                it.foldResponse(
                    requireContext(),
                    onLoading = { /* show loading */ },
                    onStopLoading = { /* stop loading */ },
                    onSuccess = { /* do some work */ },
                    onFailure = { /* show failure message */ }
                )
            }
        }
    }
}