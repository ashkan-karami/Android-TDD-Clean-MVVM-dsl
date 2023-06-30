package com.ashkan.userprofile.features.login.data.dataSource.data.network.models

import com.ashkan.userprofile.common.base_domain.model.EntityModel
import com.ashkan.userprofile.features.login.domain.data.LoginResponse
import com.squareup.moshi.Json

data class LoginResponseModel(
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "email")
    val email: String,
): EntityModel<LoginResponse>{

    override fun toDomain(): LoginResponse =
        LoginResponse(
            id = id,
            name = name,
            email = email
        )
}