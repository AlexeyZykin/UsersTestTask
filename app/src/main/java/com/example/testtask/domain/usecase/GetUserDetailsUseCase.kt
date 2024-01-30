package com.example.testtask.domain.usecase

import com.example.testtask.domain.model.UserDetails
import com.example.testtask.domain.repository.UserRepository

class GetUserDetailsUseCase(private val userRepository: UserRepository) {
    suspend fun invoke(id: Int): UserDetails {
        return userRepository.getUser(id)
    }
}