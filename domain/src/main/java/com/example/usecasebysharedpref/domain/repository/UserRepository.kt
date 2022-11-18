package com.example.usecasebysharedpref.domain.repository

import com.example.usecasebysharedpref.domain.model.NameParam
import com.example.usecasebysharedpref.domain.model.UserName

interface UserRepository {

    fun saveName(nameParam: NameParam): Boolean

    fun getName(): UserName

}