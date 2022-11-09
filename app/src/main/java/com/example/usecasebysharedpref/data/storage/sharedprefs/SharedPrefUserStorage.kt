package com.example.usecasebysharedpref.data.storage.sharedprefs

import android.content.Context
import com.example.usecasebysharedpref.data.storage.UserStorage
import com.example.usecasebysharedpref.data.storage.model.StorageParam
import com.example.usecasebysharedpref.data.storage.model.UserNameStorage

private const val SHARED_PREFS_NAME = "shared_prefs_name"//файл настроек SharedPreferences
private const val KEY_FIRST_NAME = "firstName"
private const val KEY_LAST_NAME = "lastName"
private const val DEFAULT_FIRST_NAME = "defaultFirstName"
private const val DEFAULT_LAST_NAME = "defaultLastName"


class SharedPrefUserStorage(context: Context): UserStorage {
    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)
    override fun save(userNameStorage: UserNameStorage): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, userNameStorage.firstName).apply()
        sharedPreferences.edit().putString(KEY_LAST_NAME, userNameStorage.lastName).apply()
        return true
    }

    override fun getData(): UserNameStorage {
        var firstName = sharedPreferences.getString(KEY_FIRST_NAME,DEFAULT_FIRST_NAME)?: DEFAULT_FIRST_NAME
        var lastName = sharedPreferences.getString(KEY_LAST_NAME, DEFAULT_LAST_NAME)?: DEFAULT_LAST_NAME
        return UserNameStorage(firstName = firstName, lastName = lastName)
    }
}