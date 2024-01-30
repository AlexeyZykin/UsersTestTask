package com.example.testtask.domain.repository

import com.example.testtask.domain.model.UserDetails
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun getUserList(): Flow<List<UserDetails>>
    suspend fun getUser(id: Int): UserDetails
    suspend fun updateUserList(): Flow<List<UserDetails>>
}