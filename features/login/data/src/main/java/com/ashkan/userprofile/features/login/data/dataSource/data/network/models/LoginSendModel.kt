package com.ashkan.userprofile.features.login.data.dataSource.data.network.models

import com.squareup.moshi.Json

data class LoginSendModel(
    @Json(name = "userName")
    val userName: String,
    @Json(name = "password")
    val password: String
)