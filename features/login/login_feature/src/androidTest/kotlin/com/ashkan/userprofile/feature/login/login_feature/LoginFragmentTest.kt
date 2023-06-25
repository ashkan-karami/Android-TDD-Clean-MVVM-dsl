package com.ashkan.userprofile.feature.login.login_feature

import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.DataInteraction
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ashkan.userprofile.features.login.login_feature.R
import com.ashkan.userprofile.features.login.login_feature.ui.LoginFragment
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.equalTo
import org.hamcrest.Matchers.hasEntry
import org.hamcrest.Matchers.instanceOf
import org.hamcrest.Matchers.`is`
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

    // Consider a Recycler with a SimpleAdapter that holds data for each row in a Map<String, Object> object,
    // The code for a click on the row with "item: 50" looks like this:
    @Test
    fun testRecycler(){
        val fragmentArgs = bundleOf("selectedListItem" to 0)
        val scenario = launchFragmentInContainer<LoginFragment>(fragmentArgs)
        onData(allOf(
            `is`(instanceOf(Map::class.java)), // narrows the search to any item of the AdapterView, which is backed by a Map object.
            hasEntry(equalTo("STR"), //  will match any Map that contains an entry with the key "STR" and the value "item: 50"
            `is`("item: 50")))).perform(click())
        // Note that Espresso scrolls through the list automatically as needed.

        onRow("item: 50").onChildView(withId(R.id.button)).perform(click())
    }

    private fun onRow(str: String): DataInteraction {
        return onData(hasEntry(equalTo("item: 50"), `is`(str)))
    }

    @Test
    fun testRecycler2(){
        onView(withId(R.id.recycler)).check(matches(atPosition(0, withText("Test Text"))))
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