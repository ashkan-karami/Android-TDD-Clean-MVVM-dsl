package com.ashkan.userprofile.features.login.domain.usecase

import com.ashkan.userprofile.common.base_domain.baseUseCase.BaseFlowUseCase
import com.ashkan.userprofile.common.base_domain.baseUseCase.UseCase
import com.ashkan.userprofile.features.login.domain.data.LoginResponse
import com.ashkan.userprofile.features.login.domain.repository.LoginRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: LoginRepository
): BaseFlowUseCase<LoginUseCase.Params, LoginResponse>() {

    class Params(
        val userName: String,
        val password: String
    ): UseCase.Param

    override suspend fun execute(param: Params): Flow<Result<LoginResponse>> =
        repository.startLogin(
            userName = param.userName,
            password = param.password
        )
}