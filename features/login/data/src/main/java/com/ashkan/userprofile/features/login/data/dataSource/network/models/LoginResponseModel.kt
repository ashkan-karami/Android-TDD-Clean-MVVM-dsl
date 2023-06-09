package com.ashkan.userprofile.features.login.data.dataSource.network.models

import com.ashkan.userprofile.common.base_domain.model.EntityModel
import com.ashkan.userprofile.features.login.domain.data.LoginResponse
import com.squareup.moshi.Json

data class LoginResponseModel(
    @Json(name = "accessToken")
    val accessToken: String,
    @Json(name = "refreshToken")
    val refreshToken: String
): EntityModel<LoginResponse>{

    override fun toDomain(): LoginResponse =
        LoginResponse(
            accessToken = accessToken,
            refreshToken = refreshToken
        )
}