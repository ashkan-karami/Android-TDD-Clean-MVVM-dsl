package com.ashkan.userprofile.features.login.login_feature.di

import android.content.Context
import com.ashkan.userprofile.di.DaggerDependencies
import com.ashkan.userprofile.features.login.data.dataSource.di.DataModule
import com.ashkan.userprofile.features.login.data.dataSource.di.DatabaseModule
import dagger.BindsInstance
import dagger.Component

@Component(
    dependencies = [DaggerDependencies::class],
    modules = [
        DataModule::class,
        DatabaseModule::class,
        LoginModule::class
    ]
)
interface LoginComponent: FragmentInjector, ViewModelInjector {

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(daggerDependencies: DaggerDependencies): Builder
        fun build(): LoginComponent
    }

    companion object{
        var instance: LoginComponent? = null
    }
}