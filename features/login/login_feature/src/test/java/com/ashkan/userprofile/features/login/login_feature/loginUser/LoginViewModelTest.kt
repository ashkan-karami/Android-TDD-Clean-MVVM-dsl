package com.ashkan.userprofile.features.login.login_feature.loginUser

import com.ashkan.userprofile.common.base_domain.baseUseCase.UseCase
import com.ashkan.userprofile.features.login.domain.data.LoginResponse
import com.ashkan.userprofile.features.login.domain.usecase.LoginUseCase
import com.ashkan.userprofile.features.login.login_feature.base.StandardCoroutineRule
import com.ashkan.userprofile.features.login.login_feature.ui.LoginViewModel
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.advanceUntilIdle
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@OptIn(ExperimentalCoroutinesApi::class)
class LoginViewModelTest {

    @get:Rule
    val testCoroutineRule = StandardCoroutineRule()

    private val viewModel = LoginViewModel()
    private val loginUseCase: LoginUseCase = mock()
    private val userList: List<LoginResponse> = mock()
    private val params = UseCase.NoParam

    @Test
    fun `users api returns emptyList`() = testCoroutineRule.runTest{
        whenever(loginUseCase.invoke(params)).thenReturn( flow { emit(Result.success(emptyList())) })
        viewModel.loginUseCase = loginUseCase
        viewModel.startLogin()
        advanceUntilIdle()

        assertEquals(emptyList<LoginResponse>(), viewModel.userList)
        verify(loginUseCase, times(1)).invoke(params)
    }

    @Test
    fun `users api returns list successfully`() = testCoroutineRule.runTest{
        whenever(loginUseCase.invoke(params)).thenReturn( flow { emit(Result.success(userList)) })
        viewModel.loginUseCase = loginUseCase
        viewModel.startLogin()
        advanceUntilIdle()

        assertEquals(userList, viewModel.userList)
    }
}