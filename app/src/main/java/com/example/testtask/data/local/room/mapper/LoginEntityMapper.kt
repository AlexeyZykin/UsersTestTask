package com.example.testtask.data.local.room.mapper

import com.example.testtask.data.local.room.model.LoginEntity
import com.example.testtask.domain.model.Login

class LoginEntityMapper : Mapper<LoginEntity, Login> {
    override fun mapFromEntity(data: LoginEntity): Login {
        return Login(
            username = data.username,
            password = data.password
        )
    }

    override fun mapToEntity(data: Login): LoginEntity {
        return LoginEntity(
            username = data.username,
            password = data.password
        )
    }
}