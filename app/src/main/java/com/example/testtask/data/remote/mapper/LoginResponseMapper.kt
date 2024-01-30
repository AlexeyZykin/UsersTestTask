package com.example.testtask.data.remote.mapper

import com.example.testtask.data.remote.model.LoginResponse
import com.example.testtask.domain.model.Login

class LoginResponseMapper : Mapper<LoginResponse, Login> {
    override fun mapFromResponse(data: LoginResponse): Login {
        return Login(
            username = data.username,
            password = data.password
        )
    }

    override fun mapToResponse(data: Login): LoginResponse {
        return LoginResponse(
            username = data.username,
            password = data.password
        )
    }
}