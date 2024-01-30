package com.example.testtask.data.local.room.mapper

import com.example.testtask.data.local.room.model.UserDetailsEntity
import com.example.testtask.domain.model.UserDetails

class UserDetailsEntityMapper(
    private val nameEntityMapper: NameEntityMapper,
    private val locationEntityMapper: LocationEntityMapper,
    private val loginEntityMapper: LoginEntityMapper,
    private val dateOfBirthEntityMapper: DateOfBirthEntityMapper,
    private val pictureEntityMapper: PictureEntityMapper
) : Mapper<UserDetailsEntity, UserDetails> {

    override fun mapFromEntity(data: UserDetailsEntity): UserDetails {
        return UserDetails(
            id = data.id,
            gender = data.gender,
            name = nameEntityMapper.mapFromEntity(data.name),
            location = locationEntityMapper.mapFromEntity(data.location),
            email = data.email,
            login = loginEntityMapper.mapFromEntity(data.login),
            dob = dateOfBirthEntityMapper.mapFromEntity(data.dob),
            phone = data.phone,
            picture = pictureEntityMapper.mapFromEntity(data.picture),
            nat = data.nat
        )
    }

    override fun mapToEntity(data: UserDetails): UserDetailsEntity {
        return UserDetailsEntity(
            id = data.id,
            gender = data.gender,
            name = nameEntityMapper.mapToEntity(data.name),
            location = locationEntityMapper.mapToEntity(data.location),
            email = data.email,
            login = loginEntityMapper.mapToEntity(data.login),
            dob = dateOfBirthEntityMapper.mapToEntity(data.dob),
            phone = data.phone,
            picture = pictureEntityMapper.mapToEntity(data.picture),
            nat = data.nat
        )
    }
}