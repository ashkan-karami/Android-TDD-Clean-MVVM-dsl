package com.ashkan.userprofile.features.login.data.dataSource.repository

import com.ashkan.userprofile.common.network.apiWrapper
import com.ashkan.userprofile.features.login.data.dataSource.data.db.UserDao
import com.ashkan.userprofile.features.login.data.dataSource.data.db.toDomainModel
import com.ashkan.userprofile.features.login.data.dataSource.data.network.LoginApiService
import com.ashkan.userprofile.features.login.data.dataSource.data.network.models.LoginResponseModel
import com.ashkan.userprofile.features.login.domain.data.LoginResponse
import com.ashkan.userprofile.features.login.domain.repository.LoginRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val apiService: LoginApiService,
    private val userDao: UserDao
) : LoginRepository {

    override suspend fun startLogin(userName: String, password: String): Flow<Result<LoginResponse>> {
        val apiResult = apiWrapper<LoginResponseModel,LoginResponse>{
            apiService.startLogin()
        }
        return if (apiResult.firstOrNull()?.isSuccess == true){
            apiResult
        }else{
            flow { emit(Result.success(userDao.getUserById(1).toDomainModel())) }
        }
    }

}