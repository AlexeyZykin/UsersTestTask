package com.example.testtask.data.local.source

import com.example.testtask.data.local.room.model.UserDetailsEntity
import kotlinx.coroutines.flow.Flow


interface UserLocalDataSource {
    suspend fun getUserList(): List<UserDetailsEntity>
    suspend fun saveUserList(users: List<UserDetailsEntity>)
    suspend fun deleteUserList()
    suspend fun getUser(id: Int): UserDetailsEntity
    suspend fun userListIsCached(): Boolean
}