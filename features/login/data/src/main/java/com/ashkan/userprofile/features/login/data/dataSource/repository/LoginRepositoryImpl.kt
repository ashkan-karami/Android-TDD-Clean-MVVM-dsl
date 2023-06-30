package com.ashkan.userprofile.features.login.data.dataSource.repository

import com.ashkan.userprofile.common.network.apiWrapper
import com.ashkan.userprofile.features.login.data.dataSource.data.db.UserDao
import com.ashkan.userprofile.features.login.data.dataSource.data.db.UserEntity
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

    override suspend fun startLogin(): Flow<Result<List<LoginResponse>>> {
        return apiWrapper<List<LoginResponseModel>,List<LoginResponse>>{
            apiService.startLogin()
        }
//        return if (apiResult.firstOrNull()?.isSuccess == true){
//            updateUsers(apiResult.firstOrNull()?.getOrNull())
//            apiResult
//        }else{
//            flow { emit(Result.success(userDao.getUserById(1).toDomainModel())) }
//        }
    }

    private suspend fun updateUsers(users: LoginResponse?){
        users?.let {
            userDao.insert(UserEntity(id = it.id, name = it.name, email = it.email))
        }
    }
}