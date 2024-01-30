package com.example.testtask.data.remote.mapper

import com.example.testtask.data.remote.model.UserListResponse
import com.example.testtask.domain.model.UserDetails

class UserListResponseMapper(
    private val userDetailsResponseMapper: UserDetailsResponseMapper
) : Mapper<UserListResponse, List<UserDetails>> {

    override fun mapFromResponse(data: UserListResponse): List<UserDetails> {
        return data.results.map { userDetailsResponseMapper.mapFromResponse(it) }
    }

    override fun mapToResponse(data: List<UserDetails>): UserListResponse {
        return UserListResponse(
            results = data.map { userDetailsResponseMapper.mapToResponse(it) }
        )
    }

}