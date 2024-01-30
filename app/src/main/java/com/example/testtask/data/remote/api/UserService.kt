package com.example.testtask.data.remote.api

import com.example.testtask.data.remote.model.UserListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {
    @GET("api/")
    suspend fun getUserList(@Query("results") number: Int): UserListResponse
}