package com.ashkan.userprofile.features.login.login_feature.ui

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.ashkan.userprofile.common.navigation.NavigationFlow
import com.ashkan.userprofile.common.navigation.crossNavigate
import com.ashkan.userprofile.common.ui.BaseFragment
import com.ashkan.userprofile.common.ui.foldResponse
import com.ashkan.userprofile.features.login.login_feature.R
import com.ashkan.userprofile.features.login.login_feature.databinding.FragmentLoginBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class LoginFragment : BaseFragment<FragmentLoginBinding>(
    layout = R.layout.fragment_login
) {

    private val viewModel by viewModels<LoginViewModel>()

    override fun bind(savedInstanceState: Bundle?) {
        collectViewModel()
        dataBinding.lifecycleOwner = viewLifecycleOwner
        dataBinding.submit = {
            crossNavigate(NavigationFlow.ProfileFlow)
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