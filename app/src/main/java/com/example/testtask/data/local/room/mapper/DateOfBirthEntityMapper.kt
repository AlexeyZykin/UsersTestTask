package com.example.testtask.data.local.room.mapper

import com.example.testtask.data.local.room.model.DateOfBirthEntity
import com.example.testtask.domain.model.DateOfBirth


class DateOfBirthEntityMapper : Mapper<DateOfBirthEntity, DateOfBirth> {
    override fun mapFromEntity(data: DateOfBirthEntity): DateOfBirth {
        return DateOfBirth(
            date = data.date,
            age = data.age
        )
    }

    override fun mapToEntity(data: DateOfBirth): DateOfBirthEntity {
        return DateOfBirthEntity(
            date = data.date,
            age = data.age
        )
    }
}