package com.ashkan.userprofile.features.login.login_feature.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.ashkan.userprofile.common.navigation.NavigationFlow
import com.ashkan.userprofile.common.navigation.crossNavigate
import com.ashkan.userprofile.common.ui.*
import com.ashkan.userprofile.di.DaggerDependencies
import com.ashkan.userprofile.features.login.domain.data.LoginResponse
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

    private lateinit var adapter: LoginUserAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        inject()
        collectViewModel()
    }

    override fun bind(savedInstanceState: Bundle?) {
        dataBinding.lifecycleOwner = viewLifecycleOwner
        if (viewModel.userListFlow.value.data().isNullOrEmpty()) {
            viewModel.startLogin()
        }else{
            initAdapter()
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

    private fun collectViewModel() {
        lifecycleScope.launch {
            viewModel.userListFlow.collect {
                it.foldResponse(
                    requireContext(),
                    onLoading = { dataBinding.progressBar.visible() },
                    onStopLoading = { dataBinding.progressBar.gone() },
                    onSuccess = {
                        initAdapter()
                    },
                    onFailure = { message ->
                        toast(message ?: "Something went wrong!")
                    }
                )
            }
        }
    }

    private fun initAdapter() = with(dataBinding){
        if (!::adapter.isInitialized){
            adapter = LoginUserAdapter {
                navigateToProfile(it)
            }
        }

        recycler.adapter = adapter
        viewModel.userListFlow.value.data()?.let {
            adapter.setData(it)
        }
    }

    private fun navigateToProfile(user: LoginResponse) = lifecycleScope.launchWhenResumed {
        crossNavigate(NavigationFlow.ProfileFlow)
    }

    fun test() {

    }

    // TODO add reading from assets in case offline data needed.
}