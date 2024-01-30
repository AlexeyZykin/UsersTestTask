package com.example.testtask.di


import com.example.testtask.data.repository.UserRepositoryImpl
import com.example.testtask.domain.repository.UserRepository
import org.koin.dsl.module


val dataModule = module {
    single<UserRepository> { UserRepositoryImpl(get(), get(), get(), get()) }
}




