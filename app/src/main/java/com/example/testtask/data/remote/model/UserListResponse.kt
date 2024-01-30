package com.example.testtask.data.remote.model

import com.example.testtask.domain.model.UserDetails

data class UserListResponse(
    val results: List<UserDetailsResponse>
)
