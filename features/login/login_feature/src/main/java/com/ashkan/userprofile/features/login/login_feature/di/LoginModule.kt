package com.ashkan.userprofile.features.login.login_feature.di

import com.ashkan.userprofile.features.login.data.dataSource.data.network.LoginApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class LoginModule {

    @Provides
    fun provideBusApiService(retrofit: Retrofit) = retrofit.create(LoginApiService::class.java)
}