package com.miguelaguilar.challenge.utils

import android.annotation.SuppressLint
import android.app.ActivityManager
import android.content.ComponentName
import android.content.Context
import android.graphics.Bitmap
import android.os.Build
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import java.io.ByteArrayOutputStream
import kotlin.properties.ObservableProperty
import kotlin.reflect.KProperty


/**
 * Pass arguments to a Fragment without the hassle of
 * creating a static newInstance() method for every Fragment.
 *
 * Declared outside any class to have full access in any
 * part of your package.
 *
 * Usage: instanceOf<MyFragment>("foo" to true, "bar" to 0)
 *
 * @return Returns an instance of Fragment as the specified generic type with the params applied as arguments
 */
inline fun <reified T : Fragment> instanceOf(vararg params: Pair<String, Any>) =
    T::class.java.newInstance().apply {
        arguments = bundleOf(*params)
    }

fun convertToByteArray(bitmap: Bitmap): ByteArray {
    val baos = ByteArrayOutputStream()
    bitmap.compress(Bitmap.CompressFormat.JPEG, 80, baos)
    return baos.toByteArray()
}

@SuppressLint("ObsoleteSdkInt")
fun isAppInBackground(context: Context): Boolean {
    var isInBackground: Boolean = true
    val am: ActivityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT_WATCH) {
        val runningProccess = am.runningAppProcesses
        runningProccess.forEach { proccessInfo ->
            if (proccessInfo.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND)
                proccessInfo.pkgList.forEach { activeProcess ->
                    if (activeProcess.equals(context.packageName))
                        isInBackground = false
                }
        }
    } else {
        @Suppress("DEPRECATION")
        val taskInfo = am.getRunningTasks(1)
        val componentInfo: ComponentName? = taskInfo.get(0).topActivity
        if (componentInfo?.packageName.equals(context.packageName))
            isInBackground = false
    }
    return isInBackground
}

fun getAWSS3Resource(key: String): String {
    return key
    /*
    viewModel.getAWSPresigned("portadayoutube/youtube.jpg") {
            error { "URLPresigned $it" }
        }
     */
}

fun <T> observing(initialValue: T, willSet: () -> Unit = {}, didSet: () -> Unit = {}) =
    object : ObservableProperty<T>(initialValue) {
        override fun beforeChange(property: KProperty<*>, oldValue: T, newValue: T): Boolean =
            true.apply { willSet() }

        override fun afterChange(property: KProperty<*>, oldValue: T, newValue: T) = didSet()
    }

