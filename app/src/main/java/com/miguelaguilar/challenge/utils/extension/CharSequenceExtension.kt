package com.miguelaguilar.challenge.utils.extension

import android.text.TextUtils
import android.util.Patterns

fun CharSequence.isValidEmail(): Boolean {
    return !TextUtils.isEmpty(this) && Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun CharSequence.isValidPassword(): Boolean {
    return !TextUtils.isEmpty(this) && Patterns.EMAIL_ADDRESS.matcher(this).matches()
}
