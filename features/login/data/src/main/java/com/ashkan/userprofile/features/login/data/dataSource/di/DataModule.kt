package com.ashkan.userprofile.features.login.data.dataSource.di

import com.ashkan.userprofile.features.login.data.dataSource.repository.LoginRepositoryImpl
import com.ashkan.userprofile.features.login.domain.repository.LoginRepository
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {

    @Binds
    abstract fun bindLoginRepository(repositoryImpl: LoginRepositoryImpl): LoginRepository
}