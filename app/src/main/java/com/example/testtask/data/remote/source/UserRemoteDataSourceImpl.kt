package com.example.testtask.data.remote.source


import com.example.testtask.data.remote.api.UserService
import com.example.testtask.data.remote.api.ApiConstants
import com.example.testtask.data.remote.model.UserDetailsResponse


class UserRemoteDataSourceImpl(private val userService: UserService) : UserRemoteDataSource {
    override suspend fun getUserList(): List<UserDetailsResponse> {
        return userService.getUserList(ApiConstants.USERS_NUMBER_REQUEST).results
    }
}