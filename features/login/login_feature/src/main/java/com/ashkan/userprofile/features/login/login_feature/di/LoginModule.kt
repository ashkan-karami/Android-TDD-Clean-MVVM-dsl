package com.ashkan.userprofile.features.login.login_feature.di

import com.ashkan.userprofile.features.login.data.dataSource.network.LoginApiService
import com.ashkan.userprofile.features.login.data.dataSource.repository.LoginRepositoryImpl
import com.ashkan.userprofile.features.login.domain.repository.LoginRepository
import com.ashkan.userprofile.features.login.domain.usecase.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LoginModule {

    @Provides
    @Singleton
    fun provideLoginApiService(retrofit: Retrofit): LoginApiService = retrofit.create(LoginApiService::class.java)

    @Provides
    @Singleton
    fun provideRepository(apiService: LoginApiService): LoginRepository =
        LoginRepositoryImpl(apiService)

    @Provides
    @Singleton
    fun provideUseCase(repository: LoginRepository): LoginUseCase =
        LoginUseCase(repository)
}