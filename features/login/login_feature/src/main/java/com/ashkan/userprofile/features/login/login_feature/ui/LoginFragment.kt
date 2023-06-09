package com.ashkan.userprofile.features.login.login_feature.ui

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.ashkan.userprofile.common.navigation.NavigationFlow
import com.ashkan.userprofile.common.navigation.crossNavigate
import com.ashkan.userprofile.common.ui.BaseFragment
import com.ashkan.userprofile.features.login.login_feature.R
import com.ashkan.userprofile.features.login.login_feature.databinding.FragmentLoginBinding

class LoginFragment : BaseFragment<FragmentLoginBinding>(
    layout = R.layout.fragment_login
) {

    private val viewModel by viewModels<LoginViewModel>()

    override fun bind(savedInstanceState: Bundle?) {
        dataBinding.lifecycleOwner = viewLifecycleOwner
        dataBinding.submit = {
            crossNavigate(NavigationFlow.ProfileFlow)
        }
    }
}