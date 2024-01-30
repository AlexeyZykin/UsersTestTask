package com.example.testtask.data.remote.mapper

import com.example.testtask.data.remote.model.DateOfBirthResponse
import com.example.testtask.domain.model.DateOfBirth

class DateOfBirthResponseMapper : Mapper<DateOfBirthResponse, DateOfBirth> {
    override fun mapFromResponse(data: DateOfBirthResponse): DateOfBirth {
        return DateOfBirth(
            date = data.date,
            age = data.age
        )
    }

    override fun mapToResponse(data: DateOfBirth): DateOfBirthResponse {
        return DateOfBirthResponse(
            date = data.date,
            age = data.age
        )
    }
}