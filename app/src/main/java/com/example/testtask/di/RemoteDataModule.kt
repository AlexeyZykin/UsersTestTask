package com.example.testtask.di

import com.example.testtask.data.remote.api.ApiConstants
import com.example.testtask.data.remote.api.UserService
import com.example.testtask.data.remote.mapper.CoordinatesResponseMapper
import com.example.testtask.data.remote.mapper.DateOfBirthResponseMapper
import com.example.testtask.data.remote.mapper.LocationResponseMapper
import com.example.testtask.data.remote.mapper.LoginResponseMapper
import com.example.testtask.data.remote.mapper.NameResponseMapper
import com.example.testtask.data.remote.mapper.PictureResponseMapper
import com.example.testtask.data.remote.mapper.StreetResponseMapper
import com.example.testtask.data.remote.mapper.TimezoneResponseMapper
import com.example.testtask.data.remote.mapper.UserDetailsResponseMapper
import com.example.testtask.data.remote.mapper.UserListResponseMapper
import com.example.testtask.data.remote.source.UserRemoteDataSource
import com.example.testtask.data.remote.source.UserRemoteDataSourceImpl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val remoteDataModule = module {
    single { provideRetrofit(get()) }
    single { provideUserService(get()) }
    single { provideInterceptor() }
    single { provideOkHttpClient(get()) }
    single<UserRemoteDataSource> { UserRemoteDataSourceImpl(get()) }
    factory { UserListResponseMapper(get()) }
    factory { UserDetailsResponseMapper(get(), get(), get(), get(), get()) }
    factory { DateOfBirthResponseMapper() }
    factory { LoginResponseMapper() }
    factory { NameResponseMapper() }
    factory { PictureResponseMapper() }
    factory { LocationResponseMapper(get(), get(), get()) }
    factory { StreetResponseMapper() }
    factory { TimezoneResponseMapper() }
    factory { CoordinatesResponseMapper() }
}

private fun provideRetrofit(client: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .baseUrl(ApiConstants.BASE_URL)
        .build()
}

private fun provideUserService(retrofit: Retrofit): UserService {
    return retrofit.create(UserService::class.java)
}

private fun provideInterceptor(): HttpLoggingInterceptor {
    return HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
}

private fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()
}