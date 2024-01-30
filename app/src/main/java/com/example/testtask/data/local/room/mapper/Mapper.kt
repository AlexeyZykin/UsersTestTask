package com.example.testtask.data.local.room.mapper

interface Mapper<Entity, Model> {
    fun mapFromEntity(data: Entity): Model
    fun mapToEntity(data: Model): Entity
}