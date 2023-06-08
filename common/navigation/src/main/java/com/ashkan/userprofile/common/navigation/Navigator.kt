package com.ashkan.userprofile.common.navigation

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import java.lang.ref.WeakReference

object Navigator {

    lateinit var navControllerReference: WeakReference<NavController>
    val navController: NavController?
    get() = navControllerReference.get()
}

inline fun <reified T> Fragment.crossNavigate(
    navigationFlow: NavigationFlow,
    args: T? = null,
) {
    when(navigationFlow){
        NavigationFlow.ProfileFlow -> navigateToProfile()
    }
}

fun navigateToProfile() = Navigator.navController?.navigate(R.id.profile_graph)