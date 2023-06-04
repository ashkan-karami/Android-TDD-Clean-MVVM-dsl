package com.ashkan.userprofile.common.core.validation

fun String.isAValidPassport(): Boolean = this.uppercase().matches("[A-Z]{1}[0-9]{7}".toRegex())

fun String.isAValidName(): Boolean = this.matches("^\\+[0-9]{10,13}$".toRegex())