package com.example.testtask.data.remote.mapper

import com.example.testtask.data.remote.model.PictureResponse
import com.example.testtask.domain.model.Picture

class PictureResponseMapper : Mapper<PictureResponse, Picture> {
    override fun mapFromResponse(data: PictureResponse): Picture {
        return Picture(
            large = data.large,
            medium = data.medium
        )
    }

    override fun mapToResponse(data: Picture): PictureResponse {
        return PictureResponse(
            large = data.large,
            medium = data.medium
        )
    }

}