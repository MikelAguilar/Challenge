package com.miguelaguilar.challenge.utils.extension

import android.text.Editable
import android.text.TextUtils
import android.util.Patterns
import android.webkit.URLUtil
import org.jetbrains.annotations.Contract
import android.text.Html
import android.os.Build
import android.text.Spanned



fun String.isValidEmail(): Boolean {
    return !TextUtils.isEmpty(this) && Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun String.isValidPassword(): Boolean {
    return !TextUtils.isEmpty(this) && (this.length > 7)
}

fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)


@Contract("null -> false")
fun String.isValidWebUrl(): Boolean {
    return URLUtil.isValidUrl(this)
}

fun String.isDevelopmentCard(): Boolean {

    if (this.equals("4242424242424242")) {
        return true
    }
    if (this.equals("4012888888881881")) {
        return true
    }
    if (this.equals("5555555555554444")) {
        return true
    }
    if (this.equals("5105105105105100")) {
        return true
    }
    if (this.equals("378282246310005")) {
        return true
    }
    if (this.equals("371449635398431")) {
        return true
    }
    if (this.equals("4000000000000002")) {
        return true
    }
    if (this.equals("4000000000000127")) {
        return true
    }
    if (this.equals("4111111111111111")) {
        return true
    }

    return false

}


private fun String.getSpannedText(): Spanned {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Html.fromHtml(this, Html.FROM_HTML_MODE_COMPACT)
    } else {
        @Suppress("DEPRECATION")
        Html.fromHtml(this)
    }
}