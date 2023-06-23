package com.ashkan.userprofile.features.login.data.dataSource.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ashkan.userprofile.features.login.domain.data.LoginResponse

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey(autoGenerate = true) var primaryKey: Int,
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name") val name: String
)

internal fun UserEntity.toDomainModel() = LoginResponse(
    id = id,
    name = name
)