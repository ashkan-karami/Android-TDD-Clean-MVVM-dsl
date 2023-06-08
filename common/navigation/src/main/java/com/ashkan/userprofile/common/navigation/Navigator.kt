package com.ashkan.userprofile.common.navigation

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import java.lang.ref.WeakReference

object Navigator {

    lateinit var navControllerReference: WeakReference<NavController>
    val navController: NavController?
    get() = navControllerReference.get()
}

fun Fragment.crossNavigate(
    navigationFlow: NavigationFlow) {
    when(navigationFlow){
        NavigationFlow.ProfileFlow -> navigateToProfile()
    }
}

private fun navigateToProfile() = Navigator.navController?.navigate(R.id.profile_graph)