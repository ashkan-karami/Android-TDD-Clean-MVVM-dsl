package com.ashkan.userprofile.features.login.data.dataSource.data.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: UserEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(user: List<UserEntity>)

    @Update
    suspend fun update(user: UserEntity)

    @Delete
    suspend fun delete(user: UserEntity)

    @Query("DELETE FROM user")
    suspend fun deleteAll()

    @Query("DELETE FROM user WHERE id = :id")
    fun deleteUserById(id: Int)

    @Query("SELECT * FROM user ORDER BY id")
    suspend fun getAllUsers(): List<UserEntity>

    @get:Query("SELECT * FROM user ORDER BY id")
    val allUsers: Flow<List<UserEntity>>

    @Query("SELECT * FROM user WHERE id = :id")
    suspend fun getUserById(id: Int): UserEntity
}