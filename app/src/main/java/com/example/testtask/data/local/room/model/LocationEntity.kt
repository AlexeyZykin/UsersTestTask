package com.example.testtask.data.local.room.model

import androidx.room.Embedded


data class LocationEntity(
    @Embedded
    val street: StreetEntity,
    val city: String,
    val state: String,
    val country: String,
    val postcode: String,
    @Embedded
    val timezone: TimezoneEntity,
    @Embedded
    val coordinates: CoordinatesEntity
)

data class StreetEntity(
    val number: Int,
    val name: String
)

data class TimezoneEntity(
    val offset: String,
    val description: String
)

data class CoordinatesEntity(
    val latitude: String,
    val longitude: String
)