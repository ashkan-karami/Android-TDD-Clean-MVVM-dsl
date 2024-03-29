package com.ashkan.userprofile.di

import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@EntryPoint
@InstallIn(SingletonComponent::class)
interface DaggerDependencies {

    fun providesRetrofit(): Retrofit
}