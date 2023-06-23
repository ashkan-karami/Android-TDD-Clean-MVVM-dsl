package com.ashkan.userprofile.features.login.domain.repository

import com.ashkan.userprofile.features.login.domain.data.LoginResponse
import kotlinx.coroutines.flow.Flow

interface LoginRepository {

    suspend fun startLogin(userName: String, password: String): Flow<Result<LoginResponse>>
}