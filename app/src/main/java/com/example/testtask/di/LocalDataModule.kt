package com.example.testtask.di

import android.content.Context
import androidx.room.Room
import com.example.testtask.data.local.room.constants.RoomConstants
import com.example.testtask.data.local.room.db.AppDataBase
import com.example.testtask.data.local.room.mapper.CoordinatesEntityMapper
import com.example.testtask.data.local.room.mapper.DateOfBirthEntityMapper
import com.example.testtask.data.local.room.mapper.LocationEntityMapper
import com.example.testtask.data.local.room.mapper.LoginEntityMapper
import com.example.testtask.data.local.room.mapper.NameEntityMapper
import com.example.testtask.data.local.room.mapper.PictureEntityMapper
import com.example.testtask.data.local.room.mapper.StreetEntityMapper
import com.example.testtask.data.local.room.mapper.TimezoneEntityMapper
import com.example.testtask.data.local.room.mapper.UserDetailsEntityMapper
import com.example.testtask.data.local.source.UserLocalDataSource
import com.example.testtask.data.local.source.UserLocalDataSourceImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val localDataModule = module {
    single<UserLocalDataSource> { UserLocalDataSourceImpl(get()) }
    single { provideDataBase(androidContext()) }
    single { provideDao(get()) }
    factory { UserDetailsEntityMapper(get(), get(), get(), get(), get()) }
    factory { DateOfBirthEntityMapper() }
    factory { LocationEntityMapper(get(), get(), get()) }
    factory { StreetEntityMapper() }
    factory { TimezoneEntityMapper() }
    factory { CoordinatesEntityMapper() }
    factory { LoginEntityMapper() }
    factory { NameEntityMapper() }
    factory { PictureEntityMapper() }
}

private fun provideDataBase(context: Context): AppDataBase {
    return Room.databaseBuilder(
        context,
        AppDataBase::class.java,
        RoomConstants.DB_NAME
    ).build()
}

private fun provideDao(dataBase: AppDataBase) = dataBase.getUserDao()