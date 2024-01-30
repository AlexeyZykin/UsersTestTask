package com.example.testtask.domain.usecase

import com.example.testtask.domain.model.UserDetails
import com.example.testtask.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class UpdateUserListUseCase(private val userRepository: UserRepository) {
    suspend fun invoke(): Flow<List<UserDetails>> {
        return userRepository.updateUserList()
    }
}