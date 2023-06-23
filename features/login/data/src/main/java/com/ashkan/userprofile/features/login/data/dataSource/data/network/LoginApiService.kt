package com.ashkan.userprofile.features.login.data.dataSource.data.network

import com.ashkan.userprofile.features.login.data.dataSource.data.network.models.LoginResponseModel
import retrofit2.http.GET

interface LoginApiService {

    @GET("users/1")
    suspend fun startLogin(): LoginResponseModel
}