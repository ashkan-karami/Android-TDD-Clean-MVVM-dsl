package com.ashkan.userprofile.common.network

import com.ashkan.userprofile.common.base_domain.model.DomainModel
import com.ashkan.userprofile.common.base_domain.model.EntityModel

fun<T : EntityModel<*>> entityToDomain(entity : T) : DomainModel{
    return entity.toDomain()
}

fun <T : List<EntityModel<*>>> entityListToDomainList(entityList : T) : List<DomainModel>{
    return entityList.map { it.toDomain() }
}