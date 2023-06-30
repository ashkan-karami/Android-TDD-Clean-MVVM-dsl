package com.ashkan.userprofile.features.login.login_feature.loginUser

import com.ashkan.userprofile.common.base_domain.baseUseCase.UseCase
import com.ashkan.userprofile.common.network.NetworkExceptions
import com.ashkan.userprofile.features.login.domain.data.LoginResponse
import com.ashkan.userprofile.features.login.domain.repository.LoginRepository
import com.ashkan.userprofile.features.login.domain.usecase.LoginUseCase
import com.ashkan.userprofile.features.login.login_feature.base.StandardCoroutineRule
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.advanceUntilIdle
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class LoginUseCaseTest {

    @get:Rule
    val testCoroutineRule = StandardCoroutineRule()

    private val repository: LoginRepository = mock()
    private val loginUseCase = LoginUseCase(repository)
    private val params = UseCase.NoParam
    private val userList: List<LoginResponse> = mock()
    private val throwable: Throwable = mock()
    private val timeOutMessage = "Couldn't connect to the serve!"
    private val networkException: Throwable = NetworkExceptions.TimeOutException(timeOutMessage, throwable)

    @Test
    fun `verify useCase hits repository`() = testCoroutineRule.runTest{
        loginUseCase.invoke(params)
        verify(repository, times(1)).getAllUsers()
    }

    @Test
    fun `api returns empty list`() = testCoroutineRule.runTest{
        whenever(repository.getAllUsers()).thenReturn(flow { emit(Result.success(emptyList())) })
        val users = loginUseCase.invoke(params).first().getOrNull()
        advanceUntilIdle()

        assertEquals(emptyList<LoginResponse>(), users)
    }

    @Test
    fun `api returns user-list`() = testCoroutineRule.runTest{
        whenever(repository.getAllUsers()).thenReturn(flow { emit(Result.success(userList)) })
        val users = loginUseCase.invoke(params).first().getOrNull()
        advanceUntilIdle()

        assertEquals(userList, users)
    }

    @Test
    fun `api fails`() = testCoroutineRule.runTest{
        whenever(repository.getAllUsers()).thenReturn(flow { emit(Result.failure(networkException)) })
        val users = loginUseCase.invoke(params).first().exceptionOrNull()
        advanceUntilIdle()

        assertEquals(timeOutMessage, users?.message)
    }
}