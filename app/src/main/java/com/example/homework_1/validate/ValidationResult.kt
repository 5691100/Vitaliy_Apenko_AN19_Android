package com.example.homework_1.validate

sealed class ValidationResult{
    object Valid: ValidationResult()
    class Invalid(val errorId: Int): ValidationResult()
}
