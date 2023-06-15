package com.example.homework_1.util

import android.widget.TextView

fun TextView.addLines() {
    maxLines = if (lineCount == 2) {
        Int.MAX_VALUE
    } else {
        2
    }
}