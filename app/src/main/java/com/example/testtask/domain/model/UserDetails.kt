package com.example.testtask.domain.model


data class UserDetails(
    val id: Int?,
    val gender: String,
    val name: Name,
    val location: Location,
    val email: String,
    val login: Login,
    val dob: DateOfBirth,
    val phone: String,
    val picture: Picture,
    val nat: String
)







