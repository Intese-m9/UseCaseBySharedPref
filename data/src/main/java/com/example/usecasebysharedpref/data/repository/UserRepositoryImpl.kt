package com.example.usecasebysharedpref.data.repository

import com.example.usecasebysharedpref.data.storage.UserStorage
import com.example.usecasebysharedpref.data.storage.model.UserNameStorage
import com.example.usecasebysharedpref.domain.model.NameParam
import com.example.usecasebysharedpref.domain.model.UserName
import com.example.usecasebysharedpref.domain.repository.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage): UserRepository {

    override fun saveName(nameParam: NameParam): Boolean{
       val user = UserNameStorage(firstName = nameParam.nameParam, lastName = "Petryha")
       return userStorage.save(user)
    }

    override fun getName(): UserName {
        val user = userStorage.getData()
        return UserName(firstName = user.firstName, lastName = user.lastName)
    }


}