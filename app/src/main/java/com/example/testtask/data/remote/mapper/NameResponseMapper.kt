package com.example.testtask.data.remote.mapper

import com.example.testtask.data.remote.model.NameResponse
import com.example.testtask.domain.model.Name

class NameResponseMapper : Mapper<NameResponse, Name> {
    override fun mapFromResponse(data: NameResponse): Name {
        return Name(
            title = data.title,
            first = data.first,
            last = data.last
        )
    }

    override fun mapToResponse(data: Name): NameResponse {
        return NameResponse(
            title = data.title,
            first = data.first,
            last = data.last
        )
    }
}