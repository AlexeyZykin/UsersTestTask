package com.example.testtask.presentation.userList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtask.domain.usecase.GetUserListUseCase
import com.example.testtask.domain.usecase.UpdateUserListUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch


class UserListViewModel(
    private val getUserListUseCase: GetUserListUseCase,
    private val updateUserListUseCase: UpdateUserListUseCase
) : ViewModel() {
    private val _userList = MutableLiveData<UserUiState>()
    val userList: LiveData<UserUiState> get() = _userList

    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        _userList.postValue(UserUiState.Error(exception.message ?: "Error"))
    }

    fun getUserList() = viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
        _userList.postValue(UserUiState.Loading)
        getUserListUseCase.invoke().distinctUntilChanged().collect {
            it.let {
                _userList.postValue(UserUiState.Success(it))
            }
        }
    }

    fun updateUserList() = viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
        _userList.postValue(UserUiState.Loading)
        updateUserListUseCase.invoke().distinctUntilChanged().collect {
            it.let {
                _userList.postValue(UserUiState.Success(it))
            }
        }
    }
}