package com.ashkan.userprofile.feature.login.login_feature

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TestExm {

    @Test
    fun test(){
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        Assert.assertEquals("com.ashkan.userprofile", appContext.packageName)
    }
}