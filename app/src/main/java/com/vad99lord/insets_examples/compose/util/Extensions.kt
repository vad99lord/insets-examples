package com.vad99lord.insets_examples.compose.util

import android.text.format.DateUtils

fun Long.toFormattedTime(): String {
    return DateUtils.formatElapsedTime(this)
}

fun Float.fractionToElapsedTime(duration: Long): Long{
    return this.times(duration).toLong()
}