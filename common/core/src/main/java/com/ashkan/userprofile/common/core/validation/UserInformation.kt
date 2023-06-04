package com.ashkan.userprofile.common.core.validation

fun String.isAValidPassport(): Boolean = this.matches("^(?!^0+\$)[a-zA-Z0-9]{3,20}\$".toRegex())

fun String.isAValidPhoneNumber(): Boolean = this.matches("^\\+[0-9]{10,13}$".toRegex())