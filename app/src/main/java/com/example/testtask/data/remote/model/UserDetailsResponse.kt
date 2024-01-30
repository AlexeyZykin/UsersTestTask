package com.example.testtask.data.remote.model

import com.example.testtask.domain.model.DateOfBirth
import com.example.testtask.domain.model.Location
import com.example.testtask.domain.model.Login
import com.example.testtask.domain.model.Name
import com.example.testtask.domain.model.Picture

data class UserDetailsResponse(
    val gender: String,
    val name: NameResponse,
    val location: LocationResponse,
    val email: String,
    val login: LoginResponse,
    val dob: DateOfBirthResponse,
    val phone: String,
    val picture: PictureResponse,
    val nat: String
)