package com.example.testtask.data.remote.mapper

import com.example.testtask.data.remote.model.UserDetailsResponse
import com.example.testtask.domain.model.UserDetails

class UserDetailsResponseMapper(
    private val nameResponseMapper: NameResponseMapper,
    private val locationResponseMapper: LocationResponseMapper,
    private val loginResponseMapper: LoginResponseMapper,
    private val dateOfBirthResponseMapper: DateOfBirthResponseMapper,
    private val pictureResponseMapper: PictureResponseMapper
) : Mapper<UserDetailsResponse, UserDetails> {

    override fun mapFromResponse(data: UserDetailsResponse): UserDetails {
        return UserDetails(
            id = null,
            gender = data.gender,
            name = nameResponseMapper.mapFromResponse(data.name),
            location = locationResponseMapper.mapFromResponse(data.location),
            email = data.email,
            login = loginResponseMapper.mapFromResponse(data.login),
            dob = dateOfBirthResponseMapper.mapFromResponse(data.dob),
            phone = data.phone,
            picture = pictureResponseMapper.mapFromResponse(data.picture),
            nat = data.nat
        )
    }

    override fun mapToResponse(data: UserDetails): UserDetailsResponse {
        return UserDetailsResponse(
            gender = data.gender,
            name = nameResponseMapper.mapToResponse(data.name),
            location = locationResponseMapper.mapToResponse(data.location),
            email = data.email,
            login = loginResponseMapper.mapToResponse(data.login),
            dob = dateOfBirthResponseMapper.mapToResponse(data.dob),
            phone = data.phone,
            picture = pictureResponseMapper.mapToResponse(data.picture),
            nat = data.nat
        )
    }
}