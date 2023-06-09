package com.ashkan.userprofile.features.login.data.dataSource.repository

import com.ashkan.userprofile.common.network.apiWrapper
import com.ashkan.userprofile.features.login.data.dataSource.network.LoginApiService
import com.ashkan.userprofile.features.login.data.dataSource.network.models.LoginSendModel
import com.ashkan.userprofile.features.login.domain.data.LoginResponse
import com.ashkan.userprofile.features.login.domain.repository.LoginRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val apiService: LoginApiService
) : LoginRepository {

    override fun startLogin(userName: String, password: String): Flow<Result<LoginResponse>> =
        apiWrapper {
            apiService.startLogin(
                LoginSendModel(
                    userName,
                    password
                )
            )
        }
}