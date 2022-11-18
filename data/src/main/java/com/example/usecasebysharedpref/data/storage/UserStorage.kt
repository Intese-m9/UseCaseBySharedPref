package com.example.usecasebysharedpref.data.storage

import com.example.usecasebysharedpref.data.storage.model.UserNameStorage


interface UserStorage {

    fun save(userNameStorage: UserNameStorage): Boolean

    fun getData():UserNameStorage


}