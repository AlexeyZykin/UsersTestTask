package com.example.testtask.data.remote.source

import com.example.testtask.data.remote.model.UserDetailsResponse
import kotlinx.coroutines.flow.Flow

interface UserRemoteDataSource {
    suspend fun getUserList(): List<UserDetailsResponse>
}