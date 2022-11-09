package com.example.usecasebysharedpref.domain.usecase

import com.example.usecasebysharedpref.domain.model.UserName
import com.example.usecasebysharedpref.domain.repository.UserRepository

class GetDataUserUseCase(private val userRepository: UserRepository) {
    fun execute(): UserName{
        return userRepository.getName()
    }

}