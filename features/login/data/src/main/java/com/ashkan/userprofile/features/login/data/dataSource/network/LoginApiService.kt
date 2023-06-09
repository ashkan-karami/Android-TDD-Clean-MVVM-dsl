package com.ashkan.userprofile.features.login.data.dataSource.network

import com.ashkan.userprofile.common.network.NetworkResponse
import com.ashkan.userprofile.features.login.data.dataSource.network.models.LoginResponseModel
import com.ashkan.userprofile.features.login.data.dataSource.network.models.LoginSendModel
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApiService {

    @POST("/V2/UserProfile/Login")
    suspend fun startLogin(@Body BusSeats: LoginSendModel): NetworkResponse<LoginResponseModel>
}