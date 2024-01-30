package com.example.testtask.data.remote.model

import com.example.testtask.domain.model.Street
import com.example.testtask.domain.model.Timezone

data class LocationResponse(
    val street: StreetResponse,
    val city: String,
    val state: String,
    val country: String,
    val postcode: String,
    val timezone: TimezoneResponse,
    val coordinates: CoordinatesResponse
)

data class StreetResponse(
    val number: Int,
    val name: String
)

data class TimezoneResponse(
    val offset: String,
    val description: String
)

data class CoordinatesResponse(
    val latitude: String,
    val longitude: String
)