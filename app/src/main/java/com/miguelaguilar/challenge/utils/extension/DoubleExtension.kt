package com.miguelaguilar.challenge.utils.extension

import java.lang.String

fun Double.format(digits: Int) = String.format("%.${digits}f", this)