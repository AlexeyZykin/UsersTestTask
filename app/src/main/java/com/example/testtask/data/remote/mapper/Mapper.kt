package com.example.testtask.data.remote.mapper

interface Mapper<Response, Model> {
    fun mapFromResponse(data: Response): Model
    fun mapToResponse(data: Model): Response
}