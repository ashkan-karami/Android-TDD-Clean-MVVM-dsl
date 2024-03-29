package com.ashkan.userprofile.common.network

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

inline fun <Left, reified Right> apiWrapper(noinline request: suspend () -> Left): Flow<Result<Right>> {
    return flow {
        kotlin.runCatching {
            val response = request.invoke()
//            if (response.Status) {
//                emit(response.wrapResponse())
//            } else {
//                emit(Result.failure(NetworkExceptions.ServerStatusFalse(response.Message, null)))
//            }
            emit(response.wrapResponse())
        }.onFailure { throwable ->
            emit(
                throwable.toNetworkExceptions()
            )
        }
    }
}