package com.ashkan.userprofile.common.network

data class NetworkResponse<out T> (
    val Data: T,
    val Message: String,
    val Status: Boolean,
    val ValidationErrors: Any
)