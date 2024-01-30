package com.example.testtask.data.local.room.mapper

import com.example.testtask.data.local.room.model.CoordinatesEntity
import com.example.testtask.data.local.room.model.LocationEntity
import com.example.testtask.data.local.room.model.StreetEntity
import com.example.testtask.data.local.room.model.TimezoneEntity
import com.example.testtask.domain.model.Coordinates
import com.example.testtask.domain.model.Location
import com.example.testtask.domain.model.Street
import com.example.testtask.domain.model.Timezone

class LocationEntityMapper(
    private val streetEntityMapper: StreetEntityMapper,
    private val timezoneEntityMapper: TimezoneEntityMapper,
    private val coordinatesEntityMapper: CoordinatesEntityMapper
) : Mapper<LocationEntity, Location> {
    override fun mapFromEntity(data: LocationEntity): Location {
        return Location(
            street = streetEntityMapper.mapFromEntity(data.street),
            city = data.city,
            state = data.state,
            country = data.country,
            postcode = data.postcode,
            timezone = timezoneEntityMapper.mapFromEntity(data.timezone),
            coordinates = coordinatesEntityMapper.mapFromEntity(data.coordinates)
        )
    }

    override fun mapToEntity(data: Location): LocationEntity {
        return LocationEntity(
            street = streetEntityMapper.mapToEntity(data.street),
            city = data.city,
            state = data.state,
            country = data.country,
            postcode = data.postcode,
            timezone = timezoneEntityMapper.mapToEntity(data.timezone),
            coordinates = coordinatesEntityMapper.mapToEntity(data.coordinates)
        )
    }
}

class StreetEntityMapper : Mapper<StreetEntity, Street> {
    override fun mapFromEntity(data: StreetEntity): Street {
        return Street(
            number = data.number,
            name = data.name
        )
    }

    override fun mapToEntity(data: Street): StreetEntity {
        return StreetEntity(
            number = data.number,
            name = data.name
        )
    }


}

class TimezoneEntityMapper : Mapper<TimezoneEntity, Timezone> {
    override fun mapFromEntity(data: TimezoneEntity): Timezone {
        return Timezone(
            offset = data.offset,
            description = data.description
        )
    }

    override fun mapToEntity(data: Timezone): TimezoneEntity {
        return TimezoneEntity(
            offset = data.offset,
            description = data.description
        )
    }
}

class CoordinatesEntityMapper : Mapper<CoordinatesEntity, Coordinates> {
    override fun mapFromEntity(data: CoordinatesEntity): Coordinates {
        return Coordinates(
            latitude = data.latitude,
            longitude = data.longitude
        )
    }

    override fun mapToEntity(data: Coordinates): CoordinatesEntity {
        return CoordinatesEntity(
            latitude = data.latitude,
            longitude = data.longitude
        )
    }

}