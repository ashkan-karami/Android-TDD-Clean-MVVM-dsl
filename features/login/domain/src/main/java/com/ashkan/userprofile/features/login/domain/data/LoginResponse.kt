package com.ashkan.userprofile.features.login.domain.data

import com.ashkan.userprofile.common.base_domain.model.DomainModel

data class LoginResponse(
    val id: Int,
    val name: String,
): DomainModel
