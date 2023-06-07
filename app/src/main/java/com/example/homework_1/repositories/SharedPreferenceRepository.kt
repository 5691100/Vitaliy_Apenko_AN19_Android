package com.example.homework_1.repositories

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

private const val SHARED_PREF_FILE = "sharedPrefFile"
private const val USER_PREF_FILE = "userPrefFile"
private const val IS_FIRST_OPEN = "isFirstOpen"
private const val USER_EMAIL = "userEmail"

@Singleton
class SharedPreferenceRepository @Inject constructor(
    @ApplicationContext context: Context
) {

    private var sharedPreferences: SharedPreferences
    private var userPreferences: SharedPreferences

    init {
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_FILE, Context.MODE_PRIVATE)
        userPreferences = context.getSharedPreferences(USER_PREF_FILE, Context.MODE_PRIVATE)
    }

//    fun init(context: Context) {
//        sharedPreferences = context.getSharedPreferences(SHARED_PREF_FILE, Context.MODE_PRIVATE)
//        userPreferences = context.getSharedPreferences(USER_PREF_FILE, Context.MODE_PRIVATE)
//
//    }

    fun setIsFirstOpen(isFirstOpen: Boolean) {
        sharedPreferences?.edit {
            putBoolean(IS_FIRST_OPEN, isFirstOpen)
        }
    }

    fun isFirstOpen(): Boolean {
        return sharedPreferences?.getBoolean(IS_FIRST_OPEN, true) ?: true
    }

    fun saveUserEmail(email: String) {
        userPreferences?.edit {
            putString(USER_EMAIL, email)
        }
    }

    fun getUserEmail(): String? {
        return userPreferences?.getString(USER_EMAIL, null)
    }


    fun clearUserPreferences() {
        userPreferences?.edit {
            clear()
        }
    }
}