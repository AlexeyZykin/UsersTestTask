package com.example.testtask.data.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.testtask.data.local.room.constants.RoomConstants
import com.example.testtask.data.local.room.model.UserDetailsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM ${RoomConstants.USER_DETAILS_TABLE_NAME}")
    suspend fun getUsers(): List<UserDetailsEntity>

    @Query("SELECT * FROM ${RoomConstants.USER_DETAILS_TABLE_NAME} WHERE id = :id")
    suspend fun getUser(id: Int): UserDetailsEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsers(users: List<UserDetailsEntity>)

    @Query("DELETE FROM ${RoomConstants.USER_DETAILS_TABLE_NAME}")
    suspend fun deleteUsers()

    @Query("SELECT (SELECT COUNT(*) FROM ${RoomConstants.USER_DETAILS_TABLE_NAME}) != 0")
    suspend fun isNotEmpty(): Boolean
}