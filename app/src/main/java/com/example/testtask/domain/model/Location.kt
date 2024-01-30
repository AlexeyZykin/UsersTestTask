package com.example.testtask.domain.model

data class Location(
    val street: Street,
    val city: String,
    val state: String,
    val country: String,
    val postcode: String,
    val timezone: Timezone,
    val coordinates: Coordinates
)

data class Street(
    val number: Int,
    val name: String
)

data class Timezone(
    val offset: String,
    val description: String
)

data class Coordinates(
    val latitude: String,
    val longitude: String
)