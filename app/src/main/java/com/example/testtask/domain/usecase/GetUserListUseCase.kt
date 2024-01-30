package com.example.testtask.domain.usecase

import com.example.testtask.domain.model.UserDetails
import com.example.testtask.domain.model.UserList
import com.example.testtask.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class GetUserListUseCase(private val userRepository: UserRepository) {
    suspend fun invoke(): Flow<List<UserDetails>> {
        return userRepository.getUserList()
    }
}