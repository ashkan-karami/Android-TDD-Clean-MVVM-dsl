package com.ashkan.userprofile

import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface DaggerDependencies {

    fun providesRetrofit(): RetrofitModule
}