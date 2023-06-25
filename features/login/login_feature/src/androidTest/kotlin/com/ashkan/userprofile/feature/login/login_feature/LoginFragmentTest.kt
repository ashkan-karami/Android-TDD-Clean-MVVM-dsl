package com.ashkan.userprofile.feature.login.login_feature

import androidx.core.os.bundleOf
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ashkan.userprofile.features.login.login_feature.R
import com.ashkan.userprofile.features.login.login_feature.ui.LoginFragment
import org.junit.Test
import org.junit.runner.RunWith

/**
 *  Note: debugImplementation is used here so that the empty activity that FragmentScenario relies
 *  on is accessible by the test target process.
 */

@RunWith(AndroidJUnit4::class)
class LoginFragmentTest {

    @Test fun testLaunch(){
        val fragmentArgs = bundleOf("selectedListItem" to 0)
        val scenario = launchFragmentInContainer<LoginFragment>(fragmentArgs)
        val scenario2 = launchFragmentInContainer<LoginFragment>(
            initialState = Lifecycle.State.INITIALIZED
        )
        scenario2.moveToState(Lifecycle.State.RESUMED) // LoginFragment moves to CREATED -> STARTED -> RESUMED.
        scenario2.recreate() // Recreate the fragment

        onView(withId(R.id.button)).perform(click())

        /**
         *   Don't keep references to the fragment that is passed into onFragment(). These references
         *   consume system resources, and the references themselves might be stale, since the framework
         *   can recreate the fragment.
         */
        scenario2.onFragment { fragment ->
            fragment.test()
        }
    }
}