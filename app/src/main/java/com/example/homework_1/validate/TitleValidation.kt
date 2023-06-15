package com.example.homework_1.validate

import com.example.homework_1.R

fun titleValidation(title: String): ValidationResult {

    return when {
        title.length > 20 -> ValidationResult.Invalid(R.string.title_too_big)
        else -> ValidationResult.Valid
    }
}