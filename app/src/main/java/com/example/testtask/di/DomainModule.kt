package com.example.testtask.di

import com.example.testtask.domain.usecase.GetUserDetailsUseCase
import com.example.testtask.domain.usecase.GetUserListUseCase
import com.example.testtask.domain.usecase.UpdateUserListUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetUserListUseCase(get()) }
    factory { GetUserDetailsUseCase(get()) }
    factory { UpdateUserListUseCase(get()) }
}