package com.example.testtask.data.repository

import com.example.testtask.data.local.room.mapper.UserDetailsEntityMapper
import com.example.testtask.data.local.source.UserLocalDataSource
import com.example.testtask.data.remote.mapper.UserDetailsResponseMapper
import com.example.testtask.data.remote.source.UserRemoteDataSource
import com.example.testtask.domain.model.UserDetails
import com.example.testtask.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class UserRepositoryImpl(
    private val userRemoteDataSource: UserRemoteDataSource,
    private val userLocalDataSource: UserLocalDataSource,
    private val userDetailsResponseMapper: UserDetailsResponseMapper,
    private val userDetailsEntityMapper: UserDetailsEntityMapper
) : UserRepository {

    override suspend fun getUserList(): Flow<List<UserDetails>> = flow {
        val isCached = userLocalDataSource.userListIsCached()
        if (isCached) {
            val cachedUsers = userLocalDataSource.getUserList().map {
                userDetailsEntityMapper.mapFromEntity(it)
            }
            emit(cachedUsers)
        } else {
            val users = userRemoteDataSource.getUserList()
                .map { userDetailsResponseMapper.mapFromResponse(it) }
            userLocalDataSource.saveUserList(users.map { userDetailsEntityMapper.mapToEntity(it) })
            val loadUsersFromCache =
                userLocalDataSource.getUserList().map { userDetailsEntityMapper.mapFromEntity(it) }
            emit(loadUsersFromCache)
        }
    }

    override suspend fun getUser(id: Int): UserDetails {
        return userDetailsEntityMapper.mapFromEntity(userLocalDataSource.getUser(id))
    }

    override suspend fun updateUserList(): Flow<List<UserDetails>> = flow {
        val usersFromService =
            userRemoteDataSource.getUserList().map { userDetailsResponseMapper.mapFromResponse(it) }
        userLocalDataSource.deleteUserList()
        userLocalDataSource.saveUserList(usersFromService.map { userDetailsEntityMapper.mapToEntity(it) })
        val loadUsersFromCache =
            userLocalDataSource.getUserList().map { userDetailsEntityMapper.mapFromEntity(it) }
        emit(loadUsersFromCache)
    }
}