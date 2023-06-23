package com.ashkan.userprofile.features.login.data.dataSource.di

import android.content.Context
import androidx.room.Room
import com.ashkan.userprofile.features.login.data.dataSource.data.db.UserDao
import com.ashkan.userprofile.features.login.data.dataSource.data.db.UserDatabase
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {

    @Provides
    fun provideUserDatabase(context: Context): UserDatabase =
        Room.databaseBuilder(
            context,
            UserDatabase::class.java,
            "user.db"
        ).fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideDao(userDatabase: UserDatabase): UserDao = userDatabase.getUserDao()
}