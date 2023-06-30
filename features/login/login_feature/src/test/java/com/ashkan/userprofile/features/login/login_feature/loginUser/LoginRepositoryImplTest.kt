package com.ashkan.userprofile.features.login.login_feature.loginUser

import com.ashkan.userprofile.features.login.data.dataSource.data.db.UserDao
import com.ashkan.userprofile.features.login.data.dataSource.data.network.LoginApiService
import com.ashkan.userprofile.features.login.data.dataSource.data.network.models.LoginResponseModel
import com.ashkan.userprofile.features.login.data.dataSource.repository.LoginRepositoryImpl
import com.ashkan.userprofile.features.login.domain.data.LoginResponse
import com.ashkan.userprofile.features.login.login_feature.base.StandardCoroutineRule
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.advanceUntilIdle
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class LoginRepositoryImplTest {

    @get:Rule
    val testCoroutineRule = StandardCoroutineRule()

    private val apiService: LoginApiService = mock()
    private val userDao: UserDao = mock()
    private val repositoryImpl = LoginRepositoryImpl(apiService, userDao)
    // when mocking LoginResponseModel, function toDomain() can't be called, therefore, we create a real object.
    private val loginResponseModel = LoginResponseModel(1, "test", "test")

    @Test
    fun `verify repository hits api`() = testCoroutineRule.runTest{
        repositoryImpl.getAllUsers().first()
        advanceUntilIdle()
        verify(apiService, times(1)).getAllUsers()
    }

    @Test
    fun `api returns empty list`() = testCoroutineRule.runTest{
        whenever(apiService.getAllUsers()).thenReturn(emptyList())
        repositoryImpl.getAllUsers().collect{ // because flow is cold, we have to collect it to get response.
            assertEquals(emptyList<LoginResponse>(), it.getOrNull())
        }
    }

    @Test
    fun `api returns user list`() = testCoroutineRule.runTest{
        whenever(apiService.getAllUsers()).thenReturn(listOf(loginResponseModel))
        repositoryImpl.getAllUsers().collectLatest { result ->
            assertEquals(listOf(loginResponseModel).map { it.toDomain() }, result.getOrNull())
        }
    }
}