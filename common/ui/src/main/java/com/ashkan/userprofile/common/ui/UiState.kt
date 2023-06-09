package com.ashkan.userprofile.common.ui

import android.content.Context
import com.ashkan.userprofile.common.network.NetworkExceptions
import kotlinx.coroutines.flow.Flow

suspend fun <T> Flow<UiState<T>>.foldResponse(
    context: Context,
    onLoading: () -> Unit = {},
    onStopLoading: () -> Unit = {},
    onSuccess: (T?) -> Unit,
    onFailure: (String?) -> Unit
) {
    collect {
        it.foldResponse(context, onLoading, onStopLoading, onSuccess, onFailure)
    }
}

fun <T> UiState<T>.foldResponse(
    context: Context,
    onLoading: () -> Unit = {},
    onStopLoading: () -> Unit = {},
    onSuccess: (T?) -> Unit,
    onFailure: (String?) -> Unit
) {
    when (this) {
        is UiState.Loading -> {
            onLoading()
        }
        is UiState.Error -> {
            onStopLoading()
        }

        is UiState.Data -> {
            onStopLoading()
            onSuccess(this.data)
        }

        is UiState.Failure -> {
            onStopLoading()
            onFailure(this.message)
        }
        is UiState.None -> {
            //no-op
        }
    }
}

interface UiStateCallback<T> {
    fun isSuccess(data: T?)
    fun isFailure(message: String?)
    fun isLoading()
}

sealed class UiState<T>() {
    class Loading<T> : UiState<T>()
    class Error<T>(val exceptions: NetworkExceptions) : UiState<T>()
    class Data<T>(val data: T?) : UiState<T>()
    class Failure<T>(val message: String?) : UiState<T>()
    class None<T> : UiState<T>()
}

fun <T> Result<T>.toUiState(): UiState<T> {
    if (this.isSuccess) {
        return UiState.Data(this.getOrNull())
    } else {
        with(this.exceptionOrNull() as NetworkExceptions) {
            return if (this is NetworkExceptions.ServerStatusFalse) {
                UiState.Failure(this.message)
            } else {
                UiState.Error(this)
            }
        }
    }
}

fun <T, R> Result<T>.toUiState(action: (T?) -> R?): UiState<R> {
    if (this.isSuccess) {
        return UiState.Data(action(this.getOrNull()))
    } else {
        with(this.exceptionOrNull() as NetworkExceptions) {
            return if (this is NetworkExceptions.ServerStatusFalse) {
                UiState.Failure(this.message)
            } else {
                UiState.Error(this)
            }
        }
    }
}