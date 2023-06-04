package com.ashkan.userprofile.common.base_domain.model

interface EntityModel<T : DomainModel> {
    fun toDomain() : T
}

fun <Casted,Original>Any.castToResult(result: Result<Original>) : Result<Casted>{
    return if(result.isSuccess) Result.success(this as Casted) else Result.failure(result.exceptionOrNull()?:Throwable("Error"))
}

