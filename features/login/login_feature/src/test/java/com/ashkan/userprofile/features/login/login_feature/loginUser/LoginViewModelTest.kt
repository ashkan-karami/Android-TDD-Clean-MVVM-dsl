package com.ashkan.userprofile.features.login.login_feature.loginUser

import com.ashkan.userprofile.common.base_domain.baseUseCase.UseCase
import com.ashkan.userprofile.common.network.NetworkExceptions
import com.ashkan.userprofile.common.ui.data
import com.ashkan.userprofile.common.ui.exception
import com.ashkan.userprofile.features.login.domain.data.LoginResponse
import com.ashkan.userprofile.features.login.domain.usecase.LoginUseCase
import com.ashkan.userprofile.features.login.login_feature.base.StandardCoroutineRule
import com.ashkan.userprofile.features.login.login_feature.ui.LoginViewModel
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.advanceUntilIdle
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

/**
 *  This class tests LoginViewModel class in three scenarios:
 *  1. when function getAllUsers() returns empty list.
 *  2. when function getAllUsers() returns a list of users.
 *  3. when function getAllUsers() fails to fetch user list.
 */

@OptIn(ExperimentalCoroutinesApi::class)
class LoginViewModelTest {

    @get:Rule
    val testCoroutineRule = StandardCoroutineRule()

    private val viewModel = LoginViewModel()
    private val loginUseCase: LoginUseCase = mock()
    private val userList: List<LoginResponse> = mock()
    private val params = UseCase.NoParam
    private val throwable: Throwable = mock()
    private val timeOutMessage = "Couldn't connect to the serve!"
    private val networkException: Throwable = NetworkExceptions.TimeOutException(timeOutMessage, throwable)

    init {
        viewModel.loginUseCase = loginUseCase
    }

    /**
     *  Verify if there is a connection between viewModel and useCase and also useCase's function is
     *  successfully called from viewModel.
     */
    @Test
    fun `verify viewModel hits UseCase-Invoke`() = testCoroutineRule.runTest{
        whenever(loginUseCase.invoke(params)).thenReturn( flow { emit(Result.success(emptyList())) })
        viewModel.getAllUsers()
        advanceUntilIdle()

        verify(loginUseCase, times(1)).invoke(params)
    }

    /**
     *  Tests the scenario in which user-list in server is empty and api fetches emptyList.
     */

    @Test
    fun `users api returns emptyList`() = testCoroutineRule.runTest{
        whenever(loginUseCase.invoke(params)).thenReturn( flow { emit(Result.success(emptyList())) })
        viewModel.getAllUsers()
        advanceUntilIdle()

        assertEquals(emptyList<LoginResponse>(), viewModel.userListFlow.value.data())
    }

    /**
     *  Tests the scenario in which we have several users on the internet and api fetches users and
     *  returns a list of these users.
     */
    @Test
    fun `users api returns list successfully`() = testCoroutineRule.runTest{
        whenever(loginUseCase.invoke(params)).thenReturn( flow { emit(Result.success(userList)) })
        viewModel.getAllUsers()
        advanceUntilIdle()

        assertEquals(userList, viewModel.userListFlow.value.data())
    }

    /**
     *  Checks if for some reasons api fails and can't fetch data from server.
     */
    @Test
    fun `users api fails`() = testCoroutineRule.runTest{
        whenever(loginUseCase.invoke(params)).thenReturn( flow { emit(Result.failure(networkException)) })
        viewModel.getAllUsers()
        advanceUntilIdle()

        assertEquals(timeOutMessage, viewModel.userListFlow.value.exception()?.message)
    }
}