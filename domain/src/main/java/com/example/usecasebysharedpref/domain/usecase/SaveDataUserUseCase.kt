package com.example.usecasebysharedpref.domain.usecase

import com.example.usecasebysharedpref.domain.model.NameParam
import com.example.usecasebysharedpref.domain.repository.UserRepository

class SaveDataUserUseCase(private val userRepository: UserRepository) {

    fun execute(param: NameParam): Boolean{
        val result: Boolean = userRepository.saveName(nameParam = param)
        return result
    }


}