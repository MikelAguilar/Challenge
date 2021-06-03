package com.miguelaguilar.challenge.utils.extension

import android.app.Activity
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import java.util.*

fun Context.hideKeyboard(view: View?) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view?.windowToken, 0)
}

fun Context.getCalendar(yearInit: Int, func: (year: Int, month: Int, day: Int) -> Unit) {
    val c = Calendar.getInstance()
    val year = c.get(Calendar.YEAR) - yearInit
    val month = c.get(Calendar.MONTH)
    val day = c.get(Calendar.DAY_OF_MONTH)
    val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { _, yearTaken, monthOfYear, dayOfMonth ->
        func(yearTaken, monthOfYear + 1, dayOfMonth)
    }, year, month, day)
    dpd.show()
}

fun Context.getCalendar(func: (year: Int, month: Int, day: Int) -> Unit) {
    val c = Calendar.getInstance()
    val year = c.get(Calendar.YEAR)
    val month = c.get(Calendar.MONTH)
    val day = c.get(Calendar.DAY_OF_MONTH)
    val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { _, yearTaken, monthOfYear, dayOfMonth ->
        func(yearTaken, monthOfYear + 1, dayOfMonth)
    }, year, month, day)
    dpd.show()
}

fun Context.getTime(func: (hour: Int, minute: Int) -> Unit) {
    val c = Calendar.getInstance()
    val hourStart = c.get(Calendar.HOUR_OF_DAY)
    val minuteStart = c.get(Calendar.MINUTE)
    val dpd = TimePickerDialog(this,
        TimePickerDialog.OnTimeSetListener { _, hourOfDay, minute ->
            func(hourOfDay, minute)
        }, hourStart, minuteStart, true
    )
    dpd.show()
}

fun Context.getTime(hourStart: Int, minuteStart: Int, func: (hour: Int, minute: Int) -> Unit) {
    val dpd = TimePickerDialog(this,
        TimePickerDialog.OnTimeSetListener { _, hourOfDay, minute ->
            func(hourOfDay, minute)
        }, hourStart, minuteStart, true
    )
    dpd.show()
}