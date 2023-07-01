package com.ashkan.userprofile.feature.login.login_feature

import androidx.core.os.bundleOf
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.ashkan.userprofile.features.login.login_feature.ui.LoginFragment
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class LoginFragmentTest {

    @Test
    fun testContext(){
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        Assert.assertEquals("com.ashkan.userprofile", appContext.packageName)
    }

    @Test fun testLaunch(){
        val fragmentArgs = bundleOf("selectedListItem" to 0)
        val scenario = launchFragmentInContainer<LoginFragment>(fragmentArgs)
        scenario.moveToState(Lifecycle.State.RESUMED)
    }
}