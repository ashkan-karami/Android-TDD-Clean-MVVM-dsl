package com.ashkan.userprofile.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider


@Suppress("UNCHECKED_CAST")
class ViewModelProviderFactory @Inject constructor(private val creators: MutableMap<Class<out ViewModel?>?, Provider<ViewModel?>?>?) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        var creator: Provider<out ViewModel?>? = creators!![modelClass]
        if (creator == null) {

            for (entry in creators.entries) {
                if (modelClass.isAssignableFrom(entry.key!!)) {
                    creator = entry.value
                    break
                }
            }
        }

        return try {
            creator?.let {
                it.get() as T
            }?: throw RuntimeException("Creator not found!")
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}