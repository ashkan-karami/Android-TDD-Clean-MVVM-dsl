package com.ashkan.userprofile.feature.login.login_feature

import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.DataInteraction
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.ashkan.userprofile.features.login.login_feature.R
import com.ashkan.userprofile.features.login.login_feature.ui.LoginFragment
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

/**
 *  Note: debugImplementation is used here so that the empty activity that FragmentScenario relies
 *  on is accessible by the test target process.
 */

@RunWith(AndroidJUnit4::class)
class TestExm {

    @Test
    fun test(){
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        Assert.assertEquals("com.ashkan.userprofile", appContext.packageName)
    }

    @Test fun testLaunch(){
        val fragmentArgs = bundleOf("selectedListItem" to 0)
        val scenario = launchFragmentInContainer<LoginFragment>(fragmentArgs)
        val scenario2 = launchFragmentInContainer<LoginFragment>(
            initialState = Lifecycle.State.INITIALIZED
        )
        scenario2.moveToState(Lifecycle.State.RESUMED) // LoginFragment moves to CREATED -> STARTED -> RESUMED.
        scenario2.recreate() // Recreate the fragment

        //Espresso.onView(withId(R.id.button)).perform(ViewActions.click())

        /**
         *   Don't keep references to the fragment that is passed into onFragment(). These references
         *   consume system resources, and the references themselves might be stale, since the framework
         *   can recreate the fragment.
         */
        scenario2.onFragment { fragment ->
            fragment.test()
        }
    }

    // Consider a Recycler with a SimpleAdapter that holds data for each row in a Map<String, Object> object,
    // The code for a click on the row with "item: 50" looks like this:
    @Test
    fun testRecycler(){
        val fragmentArgs = bundleOf("selectedListItem" to 0)
        val scenario = launchFragmentInContainer<LoginFragment>(fragmentArgs)
        Espresso.onData(
            Matchers.allOf(
                Matchers.`is`(Matchers.instanceOf(Map::class.java)), // narrows the search to any item of the AdapterView, which is backed by a Map object.
                Matchers.hasEntry(
                    Matchers.equalTo("STR"), //  will match any Map that contains an entry with the key "STR" and the value "item: 50"
                    Matchers.`is`("item: 50")
                )
            )
        ).perform(ViewActions.click())
        // Note that Espresso scrolls through the list automatically as needed.

        //onRow("item: 50").onChildView(withId(R.id.button)).perform(ViewActions.click())
    }

    private fun onRow(str: String): DataInteraction {
        return Espresso.onData(Matchers.hasEntry(Matchers.equalTo("item: 50"), Matchers.`is`(str)))
    }

    @Test
    fun testRecycler2(){
        Espresso.onView(ViewMatchers.withId(R.id.recycler))
            .check(ViewAssertions.matches(atPosition(0, ViewMatchers.withText("Test Text"))))
    }

    private fun atPosition(position: Int, itemMatcher: Matcher<View>): Matcher<View> {
        return object : BoundedMatcher<View, RecyclerView>(RecyclerView::class.java) {
            override fun describeTo(description: Description) {
                description.appendText("has item at position $position: ")
                itemMatcher.describeTo(description)
            }

            override fun matchesSafely(view: RecyclerView): Boolean {
                val viewHolder = view.findViewHolderForAdapterPosition(position)
                    ?: // has no item on such position
                    return false
                return itemMatcher.matches(viewHolder.itemView)
            }
        }
    }
}