package com.ashkan.userprofile.features.login.data.dataSource.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserEntity::class], version = 1)
abstract class UserDatabase: RoomDatabase() {

    abstract fun getUserDao():UserDao

}