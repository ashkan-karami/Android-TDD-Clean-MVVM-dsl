package com.ashkan.userprofile.features.login.domain.repository

import com.ashkan.userprofile.features.login.domain.data.LoginResponse
import kotlinx.coroutines.flow.Flow

interface LoginRepository {

    suspend fun getAllUsers(): Flow<Result<List<LoginResponse>>>
}