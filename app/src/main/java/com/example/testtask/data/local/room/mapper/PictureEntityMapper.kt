package com.example.testtask.data.local.room.mapper

import com.example.testtask.data.local.room.model.PictureEntity
import com.example.testtask.domain.model.Picture

class PictureEntityMapper : Mapper<PictureEntity, Picture> {
    override fun mapFromEntity(data: PictureEntity): Picture {
        return Picture(
            large = data.large,
            medium = data.medium
        )
    }

    override fun mapToEntity(data: Picture): PictureEntity {
        return PictureEntity(
            large = data.large,
            medium = data.medium
        )
    }
}