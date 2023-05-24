package com.example.homework_1.util

import com.google.android.material.textfield.TextInputLayout

fun TextInputLayout.getText(): String {
    return editText?.text?.toString() ?: ""
}