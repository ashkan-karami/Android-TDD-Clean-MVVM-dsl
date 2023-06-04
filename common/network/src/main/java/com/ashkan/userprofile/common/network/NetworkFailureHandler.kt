package com.ashkan.userprofile.common.network

import kotlinx.coroutines.TimeoutCancellationException
import retrofit2.HttpException
import java.io.IOException
import java.net.UnknownHostException
import javax.net.ssl.SSLHandshakeException


inline fun <reified Right> Throwable.toNetworkExceptions(): Result<Right> {
    return Result.failure(
        when (this) {
            is IOException, is UnknownHostException, is SSLHandshakeException -> {
                NetworkExceptions.IOException(
                    this.message,
                    this
                )
            }
            is TimeoutCancellationException -> {
                NetworkExceptions.TimeOutException(
                    this.message,
                    this
                )
            }
            is HttpException -> {
                when (this.code()) {
                    500 -> {
                        NetworkExceptions.InternalServerError(
                            this.message,
                            this
                        )
                    }
                    401 -> {
                        NetworkExceptions.UnauthorizedException(
                            this.message,
                            this
                        )
                    }
                    400 -> {
                        NetworkExceptions.BadRequestException(
                            this.message,
                            this
                        )
                    }
                    403 -> {
                        NetworkExceptions.VpnUsingException(
                            this.message,
                            this
                        )
                    }
                    else -> NetworkExceptions.UnExpectedException(
                        "unexpected exception occur",
                        this
                    )
                }
            }
            else -> {
                NetworkExceptions.UnExpectedException(
                    "unexpected exception occur",
                    this
                )
            }
        }
    )
}