package com.miguelaguilar.challenge.utils.extension

import android.app.Activity
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import org.jetbrains.anko.clearTask
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.newTask
import org.jetbrains.anko.startActivity


fun AppCompatActivity.addFragment(fragment: Fragment, frameId: Int) {
    supportFragmentManager.inTransaction { add(frameId, fragment) }
}

fun AppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int) {
    supportFragmentManager.inTransaction { replace(frameId, fragment) }
}

fun AppCompatActivity.addFragment(fragment: Fragment, frameId: Int, func: FragmentTransaction.() -> FragmentTransaction) {
    supportFragmentManager.inTransaction { add(frameId, fragment).func() }
}

fun AppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int, func: FragmentTransaction.() -> FragmentTransaction) {
    supportFragmentManager.inTransaction { replace(frameId, fragment).func() }
}

fun AppCompatActivity.removeFragment(fragment : Fragment){
    supportFragmentManager.inTransaction { remove(fragment) }
}

fun AppCompatActivity.cleanFragment() {
    supportFragmentManager.popBackStack()
}

fun AppCompatActivity.hideSystemUI() {
    // Enables regular immersive mode.
    // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
    // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
    window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE
            // Set the content to appear under the system bars so that the
            // content doesn't resize when the system bars hide and show.
            or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
            or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            // Hide the nav bar and status bar
            or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            or View.SYSTEM_UI_FLAG_FULLSCREEN)
}

// Shows the system bars by removing all the flags
// except for the ones that make the content appear under the system bars.
fun AppCompatActivity.showSystemUI() {
    window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
            or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
}

inline fun <reified T : Activity> AppCompatActivity.nextClean() {
    startActivity(intentFor<T>().newTask().clearTask())
}

inline fun <reified T : Activity> AppCompatActivity.next() {
    startActivity<T>()
}

inline fun <reified T : Activity> AppCompatActivity.nextClean(params: Pair<String, Any>) {
    startActivity(intentFor<T>(params).newTask().clearTask())
}

inline fun <reified T : Activity> AppCompatActivity.next(params: Pair<String, Any>) {
    startActivity<T>(params)
}

