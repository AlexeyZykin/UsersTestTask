package com.example.testtask.data.local.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testtask.data.local.room.dao.UserDao
import com.example.testtask.data.local.room.model.UserDetailsEntity

@Database(entities = [UserDetailsEntity::class], version = 2, exportSchema = false)
abstract class AppDataBase : RoomDatabase(){
    abstract fun getUserDao(): UserDao
}