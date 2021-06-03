package com.miguelaguilar.challenge.utils.extension

import android.content.Context
import android.content.ContextWrapper
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity

fun View.getParentActivity(): AppCompatActivity?{
    var context = this.context
    while (context is ContextWrapper) {
        if (context is AppCompatActivity) {
            return context
        }
        context = context.baseContext
    }
    return null
}

fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

fun View.addSwipeDetection(leftToRight: () -> Unit, rightToLeft: () -> Unit, topToBottom: () -> Unit, bottomToTop: () -> Unit) {
    val MIN_DISTANCE = 100
    var downX = 0.0f
    var downY = 0.0f
    var upX:Float
    var upY:Float

    this.setOnTouchListener { _, motionEvent ->

        when (motionEvent.action) {
            MotionEvent.ACTION_DOWN -> {
                downX = motionEvent.x
                downY = motionEvent.y
                return@setOnTouchListener true
            }
            MotionEvent.ACTION_UP -> {
                upX = motionEvent.x
                upY = motionEvent.y

                val deltaX = downX - upX
                val deltaY = downY - upY

                if (Math.abs(deltaX) > MIN_DISTANCE) {
                    if (deltaX < 0) {
                        leftToRight()
                        return@setOnTouchListener true
                    }
                    if (deltaX > 0) {
                        rightToLeft()
                        return@setOnTouchListener true
                    }
                }

                if (Math.abs(deltaY) > MIN_DISTANCE) {
                    if (deltaY < 0) {
                        topToBottom()
                        return@setOnTouchListener true
                    }
                    if (deltaY > 0) {
                        bottomToTop()
                        return@setOnTouchListener true
                    }
                }
                return@setOnTouchListener false
            }
            else -> return@setOnTouchListener false
        }
    }
}
