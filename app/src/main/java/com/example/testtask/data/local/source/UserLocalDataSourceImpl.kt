package com.example.testtask.data.local.source

import android.util.Log
import com.example.testtask.data.local.room.dao.UserDao
import com.example.testtask.data.local.room.model.UserDetailsEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class UserLocalDataSourceImpl(private val userDao: UserDao) : UserLocalDataSource {
    override suspend fun getUserList(): List<UserDetailsEntity> {
        return userDao.getUsers()
    }

    override suspend fun saveUserList(users: List<UserDetailsEntity>) {
        userDao.insertUsers(users)
    }

    override suspend fun deleteUserList() {
        userDao.deleteUsers()
    }

    override suspend fun getUser(id: Int): UserDetailsEntity {
        return userDao.getUser(id)
    }

    override suspend fun userListIsCached(): Boolean {
        return userDao.isNotEmpty()
    }
}