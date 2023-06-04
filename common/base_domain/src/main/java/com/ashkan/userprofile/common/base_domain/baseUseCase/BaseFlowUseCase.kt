package com.ashkan.userprofile.common.base_domain.baseUseCase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

abstract class BaseFlowUseCase<in P : UseCase.Param, out R : Any?> : UseCase {

    protected abstract fun execute(param : P) : Flow<Result<R>>
    operator fun invoke(param : P) = execute(param).flowOn(Dispatchers.IO)

}