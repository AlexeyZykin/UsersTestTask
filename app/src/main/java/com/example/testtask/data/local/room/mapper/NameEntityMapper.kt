package com.example.testtask.data.local.room.mapper

import com.example.testtask.data.local.room.model.NameEntity
import com.example.testtask.domain.model.Name

class NameEntityMapper : Mapper<NameEntity, Name> {
    override fun mapFromEntity(data: NameEntity): Name {
        return Name(
            title = data.title,
            first = data.first,
            last = data.last
        )
    }

    override fun mapToEntity(data: Name): NameEntity {
        return NameEntity(
            title = data.title,
            first = data.first,
            last = data.last
        )
    }
}