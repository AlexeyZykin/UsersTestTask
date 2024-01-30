package com.example.testtask.data.remote.mapper

import com.example.testtask.data.remote.model.CoordinatesResponse
import com.example.testtask.data.remote.model.LocationResponse
import com.example.testtask.data.remote.model.StreetResponse
import com.example.testtask.data.remote.model.TimezoneResponse
import com.example.testtask.domain.model.Coordinates
import com.example.testtask.domain.model.Location
import com.example.testtask.domain.model.Street
import com.example.testtask.domain.model.Timezone

class LocationResponseMapper(
    private val streetResponseMapper: StreetResponseMapper,
    private val timezoneResponseMapper: TimezoneResponseMapper,
    private val coordinatesResponseMapper: CoordinatesResponseMapper
) : Mapper<LocationResponse, Location> {

    override fun mapFromResponse(data: LocationResponse): Location {
        return Location(
            street = streetResponseMapper.mapFromResponse(data.street),
            city = data.city,
            state = data.state,
            country = data.country,
            postcode = data.postcode,
            timezone = timezoneResponseMapper.mapFromResponse(data.timezone),
            coordinates = coordinatesResponseMapper.mapFromResponse(data.coordinates)
        )
    }

    override fun mapToResponse(data: Location): LocationResponse {
        return LocationResponse(
            street = streetResponseMapper.mapToResponse(data.street),
            city = data.city,
            state = data.state,
            country = data.country,
            postcode = data.postcode,
            timezone = timezoneResponseMapper.mapToResponse(data.timezone),
            coordinates = coordinatesResponseMapper.mapToResponse(data.coordinates)
        )
    }
}

class StreetResponseMapper : Mapper<StreetResponse, Street> {
    override fun mapFromResponse(data: StreetResponse): Street {
        return Street(
            number = data.number,
            name = data.name
        )
    }

    override fun mapToResponse(data: Street): StreetResponse {
        return StreetResponse(
            number = data.number,
            name = data.name
        )
    }
}

class TimezoneResponseMapper : Mapper<TimezoneResponse, Timezone> {
    override fun mapFromResponse(data: TimezoneResponse): Timezone {
        return Timezone(
            offset = data.offset,
            description = data.description
        )
    }

    override fun mapToResponse(data: Timezone): TimezoneResponse {
        return TimezoneResponse(
            offset = data.offset,
            description = data.description
        )
    }

}

class CoordinatesResponseMapper : Mapper<CoordinatesResponse, Coordinates> {
    override fun mapFromResponse(data: CoordinatesResponse): Coordinates {
        return Coordinates(
            latitude = data.latitude,
            longitude = data.longitude
        )
    }

    override fun mapToResponse(data: Coordinates): CoordinatesResponse {
        return CoordinatesResponse(
            latitude = data.latitude,
            longitude = data.longitude
        )
    }

}