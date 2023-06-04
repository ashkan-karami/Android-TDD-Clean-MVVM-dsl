package com.ashkan.userprofile.common.network

import com.ashkan.userprofile.common.base_domain.model.EntityModel


inline fun <Left, reified Right> Left.wrapResponse(): Result<Right> =
    when (this) {
        is EntityModel<*> -> {
            Result.success(this.toDomain() as Right)
        }
        is List<*> -> {
            this.firstOrNull()?.let {
                if (it is String)
                    Result.success(this as Right)
                else
                    Result.success((this as List<EntityModel<*>>).map { it.toDomain() } as Right)
            } ?: Result.success((this as List<EntityModel<*>>).map { it.toDomain() } as Right)
        }
        else -> {
            Result.success(this as Right)
        }
    }
