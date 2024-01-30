package com.example.testtask.presentation.userList

import com.example.testtask.domain.model.UserDetails

sealed class UserUiState {
    data object Loading : UserUiState()
    data class Success(val users: List<UserDetails>) : UserUiState()
    data class Error(val msg: String) : UserUiState()
}