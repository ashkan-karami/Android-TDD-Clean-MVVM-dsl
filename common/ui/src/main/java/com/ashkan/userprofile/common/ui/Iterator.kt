package com.ashkan.userprofile.common.ui

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment

fun Context.toast(message: String, duration:Int = Toast.LENGTH_SHORT){
    Toast.makeText(this,message, duration).show()
}

fun Fragment.toast(message: String, duration:Int = Toast.LENGTH_SHORT){
    requireContext().toast(message,duration)
}

fun log(message: String){
    Log.i("==UserProfile==",message)
}